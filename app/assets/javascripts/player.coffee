class window.Player
  
  speed  = 3
  radius = 25
  limit  = 1000
  color  = "#00BFFF"
  
  createView: (x, y) =>
    circle = new createjs.Shape()
    circle.graphics.beginFill("#{color}").drawCircle(0, 0, radius)
    circle.x = x
    circle.y = y
    circle

  constructor: (@name, @x, @y) ->
    @id = undefined
    @lives = 1
    @life  = 100
    @alive = true
    @view  = @createView(@x, @y)
    @controls =
      pressingL     : false
      pressingR     : false
      pressingShoot : false
      pressingSpeed : false
      
  onKeyDown: (event) =>
    if event.keyCode == 37  # L
      @controls.pressingL = true
      @controls.pressingR = false
    if event.keyCode == 39  # R
      @controls.pressingL = false
      @controls.pressingR = true
    if event.keyCode == 32  # Spacebar
      @controls.pressingShoot = true
    if event.keyCode == 16  # Shift
      @controls.pressingSpeed = true
      
  onKeyUp: (event) =>
    if event.keyCode == 37  # L
      @controls.pressingL = false
    if event.keyCode == 39  # R
      @controls.pressingR = false
    if event.keyCode == 32  # Spacebar
      @controls.pressingShoot = false
    if event.keyCode == 16  # Shift
      @controls.pressingSpeed = false
      
  update: (event) =>
    if @life <= 0 && @lives >= 1
      @lives -= 1
      @life = 100
    if @life <= 0 && @lives <  1
      @alive = false
    if @controls.pressingR
      @x += speed
      if @x > limit
        @x = limit
    if @controls.pressingL
      @x -= speed
      if @x < 0
        @x = 0
    if @controls.pressingSpeed
      speed = 8
    else
      speed = 3
    if !@alive  
      event.remove()
      @view.visible = false
    @view.x = @x
    @view.y = @y

  shooting: =>
    @controls.pressingShoot
    
  shoot: =>
    new Gun(@name, @x, @y - radius, false)

  gotShot: (bullet) =>
    if @collision(bullet) && bullet.enemy
      @life -= bullet.power  
      return true
    false
      
  collision: (that) =>
    @inside(that.x, that.y)
    
  inside: (x, y) =>
    Math.sqrt((x - @x)**2 + (y - @y)**2) <= radius