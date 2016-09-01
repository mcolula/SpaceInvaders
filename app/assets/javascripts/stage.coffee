class window.Stage
  
  stage = undefined
  counter = 0
  fps = 60
  
  constructor: (@name) ->
    stage = new createjs.Stage(@name)
    stage.snapToPixelsEnabled = true
    createjs.Ticker.setFPS(fps)
    
  add: (element) =>
    stage.addChildAt(element.view)
    createjs.Ticker.on("tick", element.update) if element.update
    
  update: () =>
    stage.update()
