class window.RemotePlayer
  
  constructor: (@name, @x, @y) ->
    @alive = true
    @view  = @createView(@x, @y)
    
  update: ->
    