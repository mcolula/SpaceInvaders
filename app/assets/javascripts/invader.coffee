class window.Invader
  
  shootProbability = 0.02
  color = "#DD0A0A"
  h = 20
  w = 20
  
  createView: (x, y) =>
    rect = new createjs.Shape()
    rect.graphics.beginFill("#{color}").drawRect(x, y, w, h)
    rect

  constructor: (@x, @y) ->
    @lives = 0
    @life  = 100
    @alive = true
    @view  = @createView(@x, @y)
    
  update: (event) =>
    if @life <= 0 && @lives >= 1
      @lives -= 1
      @life = 5
    if @life <= 0 && @lives <  1
      @alive = false
    if !@alive  
      event.remove()
      @view.visible = false
  
  shooting: =>
    if @alive
      Math.random() <= shootProbability
    else
      false
    
  shoot: =>
    new SpaceGun(@x + w / 2, @y + h, true)
    
  gotShot: (bullet) =>
    if @collision(bullet) && !bullet.enemy
      @life -= bullet.power  
      return true
    false
    
  collision: (that) =>
    @inside(that.x, that.y)

  inside: (x, y) =>
    x >= @x && x <= @x + w && y >= @y && y <= @y + h
