class window.TextMessage 
  
  color  = "#FFFFFF"
  
  createView: (message, x, y, size) =>
    text = new createjs.Text(message, "#{size}px Arial", color)
    text.textBaseline = "alphabetic"
    text.x = x - text.getMeasuredWidth() * 0.5
    text.y = y
    text
    
  constructor: (@text, @x, @y, @size) ->
    @view  = @createView(@text, @x, @y, @size)
    @alive = true
  
  update: (event) =>
    if !@alive  
      event.remove() 
      @view.visible = false