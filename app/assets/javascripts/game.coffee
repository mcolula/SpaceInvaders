class window.Game
  
  width   = 1000 
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
    if @gun? && !@gun.alive
      @stage.remove(@gun)
      @gun = undefined    
    if @player.shooting() && !@gun?     
      @gun = @player.shoot()
      @stage.add(@gun)
  
  run: () => 
    
    @mainGunBehavior()

    for invader in @invaders
      if invader.alive && invader.shooting()
        @stage.add(invader.shoot())
    
    for bunker in @bunkers
      if @gun? && bunker.alive && bunker.gotShot(@gun)
        @gun.alive = false
        
    for invader in @invaders
      if @gun? && invader.alive && invader.gotShot(@gun)
        @gun.alive = false
        
        
        
@init = () ->
  game = new Game()
