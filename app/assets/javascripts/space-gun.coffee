class window.SpaceGun
  
  color  = "#FFFFAA"
  limit  = 600
  speed  = 8
  radius = 3
  
  createView: (x, y) =>
    circle = new createjs.Shape()
    circle.graphics.beginFill("#{color}").drawCircle(0, 0, radius)
    circle.x = x
    circle.y = y
    circle
  
  constructor: (@x, @y, @enemy) ->
    @id = undefined
    @alive = true
    @view  = @createView(@x, @y)
    @power = 25
  
  update: (event) =>
    @y += speed
    if @y >= limit
      @alive = false
    if !@alive  
      event.remove() 
      @view.visible = false
    @view.y = @y

