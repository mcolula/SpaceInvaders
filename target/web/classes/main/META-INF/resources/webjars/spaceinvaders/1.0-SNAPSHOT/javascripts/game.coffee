class window.Game
  
  ip = "localhost:9000"
  width  = 1000 
  height  = 600
  bunkerCount  = 6
  invaderCount = 24
  invadersPerRow =  4
  gaming = true
  score = 0
  mainMessage  = ""
  scoreMessage = ""
  livesMessage = ""
  lifeMessage  = ""
  #Other constants
  bunkerWidth  = 80
  invaderWidth = 20
  span = 40
  name = prompt("Ingresa tu nickame: ",   "")
  surl = "ws://#{ip}/socket/#{name}"
  conn = new WebSocket(surl) 
  
  constructor: ->
    @stage  = new Stage("canvas")
    @player  = new Player(name, width / 2, height)
    @stage.add(@player)
    @bunkers  = []
    @invaders = []
    @guns = []
    mainMessage  = new TextMessage("Conectando", width * 0.5, height * 0.5, 64)
    scoreMessage = new TextMessage("Score: #{score}", width * 0.25, height * 0.1, 32)
    livesMessage = new TextMessage("Lives: #{@player.lives + 1}", width * 0.5, height * 0.1, 32)
    lifeMessage  = new TextMessage("Life: #{@player.life}", width * 0.75, height * 0.1, 32)
    @stage.add(scoreMessage)
    @stage.add(livesMessage)
    @stage.add(lifeMessage)
    
    for x in [0...bunkerCount]
      @bunkers.push(new Bunker(x * (bunkerWidth + @bunkerOffset()), 0.65 * height))
    for bunker in @bunkers
      @stage.add(bunker)

    for x in [0...invaderCount]
      @invaders.push(new Invader(x * (invaderWidth + @invaderOffset()) + span, 0.30 * height))
    for invader in @invaders
      @stage.add(invader)

    for i in [0...invaderCount]
      @guns.push(undefined)
    
    if (@player.name == "mcolula")
      conn.onopen = @onOpen 
    else
      @stage.add(mainMessage)
      conn.onmessage = @onMessage
      conn.onerror = @onError
      
    @stage.update()
    
  
  onMessage: () =>
    @bindEvents(@stage) 
    mainMessage.alive = false
  
  onOpen: () =>
    conn.send("[start]")
    @bindEvents(@stage) 
    
  
  onError: () =>
    alert("Error: no se pudo establecer la conexión a internet")
  
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
    if @player.alive && @player.shooting() && !@gun?     
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
        score += 100
    
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
        @guns[i].alive = false
        
  gamePassed: () =>
    for invader in @invaders
      if invader.alive
        return
    @player.alive = false
  
  gameOverBehavior: () =>
    if !@player.alive && gaming
      gaming = false
      conn.send("[#{name}][score]#{score}")
      window.location = "http://#{ip}/score/#{name}"  
  
  updateLabels: () =>
    scoreMessage.view.text = "Score: #{score}" 
    livesMessage.view.text = "Lives: #{@player.lives + 1}" 
    lifeMessage.view.text = "Life: #{@player.life}"
    
  
  run: () => 
    
    @gameOverBehavior()
    
    @gamePassed()
    
    @updateLabels()
    
    @mainGunBehavior()

    @invadersGunBehavior()
        
        
@init = () ->
  game = new Game()

  
  