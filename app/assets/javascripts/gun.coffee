class window.Gun
  
  color  = "#FFFFFF"
  speed  = -5
  radius =  5
  
  createView: (x, y) =>
    circle = new createjs.Shape()
    circle.graphics.beginFill("#{color}").drawCircle(0, 0, radius)
    circle.x = x
    circle.y = y
    circle
  
  constructor: (@x, @y, @enemy) ->
    @alive = true
    @view  = @createView(@x, @y)
    @power = 1
  
  update: =>
    @y += speed
    if @y <= 0
      @alive = false
    @view.y = @y

