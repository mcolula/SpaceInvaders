class window.Gun
  
  color  = "#FFFFFF"
  speed  = -10
  radius =  5
  
  createView: (x, y) =>
    circle = new createjs.Shape()
    circle.graphics.beginFill("#{color}").drawCircle(0, 0, radius)
    circle.x = x
    circle.y = y
    circle
  
  constructor: (@name, @x, @y, @enemy) ->
    @id = undefined
    @view  = @createView(@x, @y)
    @alive = true
    @power = 5
  
  update: (e) =>
    @y += speed
    if @y <= 0
      @alive = false
    if !@alive  
      e.remove() 
      @view.visible = false
    @view.y = @y
