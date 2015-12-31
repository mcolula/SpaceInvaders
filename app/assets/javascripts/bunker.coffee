class window.Bunker
  
  color = "#0FDDAF"
  h = 20
  w = 80
  
  createView: (x, y) =>
    rect = new createjs.Shape()
    rect.graphics.beginFill("#{color}").drawRect(x, y, w, h)
    rect
  
  constructor: (@x, @y) ->
    @life  = 200
    @alive = true
    @view  = @createView(@x, @y)  
    
  
  gotShot: (bullet) =>
    if @collision(bullet)
      @life -= bullet.power  
      return true
    false
  
  collision: (that) =>
    @inside(that.x, that.y)
  
  inside: (x, y) =>
    x >= @x && x <= @x + w && y >= @y && y <= @y + h
    
  update: =>
    if @life <= 0
      @alive = false
    