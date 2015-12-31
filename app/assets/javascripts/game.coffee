class window.Game
  
  width  = 1000 
  height  = 600
  bunkerCount  = 6
  invaderCount = 16
  invadersPerRow =  4
  
  
  #Other constants
  bunkerWidth  = 80
  invaderWidth = 20
  span = 40
  
  constructor: ->
    @stage  = new Stage("canvas")
    
    @player  = new Player("mcolula", width / 2, height)
    @stage.add(@player)
    
    @bunkers = [] 
    for x in [0...bunkerCount]
      @bunkers.push(new Bunker(x * (bunkerWidth + @bunkerOffset()), 0.65 * height))
    for bunker in @bunkers
      @stage.add(bunker)
      
    @invaders = [] 
    for x in [0...invaderCount]
      @invaders.push(new Invader(x * (invaderWidth + @invaderOffset()) + span, 0.10 * height))
    for invader in @invaders
      @stage.add(invader)
    
    @guns = []
    for i in [0...invaderCount]
      @guns.push(undefined)
      
    @bindEvents(@stage)
    @stage.update()
      
  
  bunkerOffset: () =>
    freeSpace  = width - bunkerWidth * bunkerCount
    freeSpace /= bunkerCount - 1
    freeSpace  
  
  invaderOffset: () =>
    freeSpace  = width - invaderWidth * invaderCount - 2 * span
    freeSpace /= invaderCount - 1
    freeSpace
  
  
  bindEvents: (stage) =>
    document.onkeydown = @player.onKeyDown
    document.onkeyup   = @player.onKeyUp
    createjs.Ticker.on 'tick', stage.update
    createjs.Ticker.on 'tick', @run
    
  
  mainGunBehavior: () =>
    # Removing used bullet
    if @gun? && !@gun.alive
      @gun = undefined    
    
    # Shoots a new bullet
    if @player.shooting() && !@gun?     
      @gun = @player.shoot()
      @stage.add(@gun)
  
    # Bullet hits a bunker
    for bunker in @bunkers
      if @gun? && bunker.alive && bunker.gotShot(@gun)
        @gun.alive = false
    
    # Bullets hits an invader
    for invader in @invaders
      if @gun? && invader.alive && invader.gotShot(@gun)
        @gun.alive = false
    
  invadersGunBehavior: () =>
    for i in [0...invaderCount]
      if @guns[i]? && !@guns[i].alive
        @guns[i] = undefined
        
    for i in [0...invaderCount]
      if !@guns[i]? && @invaders[i].shooting()
        @guns[i] = @invaders[i].shoot()
        @stage.add(@guns[i])
    
    for i in [0...invaderCount]
      if @guns[i]?
        for bunker in @bunkers
          if bunker.alive && bunker.gotShot(@guns[i])
            @guns[i].alive = false
    
    for i in [0...invaderCount]
      if @guns[i]? && @player.alive && @player.gotShot(@guns[i])
        alert("got hit")
        @guns[i].alive = false
            
  run: () => 
    
    @mainGunBehavior()

    @invadersGunBehavior()
        
        
        
@init = () ->
  game = new Game()
