@stage; 
@player;
@bunker;
@objects; 
@bullets;
@invader;

@init = () -> 
  @stage  = new createjs.Stage("canvas")
  createjs.Ticker.setFPS 60
  @player  = new Player("mcolula", 500, 600)
  @bunker  = new Bunker(500, 300)
  @invader = new Invader(100, 0)
  @stage.addChild(player.view)
  @stage.addChild(bunker.view)
  @stage.addChild(invader.view)
  document.onkeydown = player.onkeyDown
  document.onkeyup   = player.onKeyUp
  createjs.Ticker.on 'tick', @update
  @objects = [player, bunker]
  @bullets = []
  
@update = () ->
  
  if invader.shooting()
    bullet = invader.shoot()
    stage.addChild(bullet.view)
    bullets.push(bullet)
  
  for object in objects
    object.update()
  
  for bullet in bullets 
    bullet.update()
    if bullet.alive && objects[1].gotShot(bullet)
      bullet.alive = false
    if bullet.alive && objects[0].gotShot(bullet)
      bullet.alive = false
    if bullet.alive && invader.gotShot(bullet)
      bullet.alive = false
   
  if player.shooting()
    bullet = player.shoot()
    stage.addChild(bullet.view)
    bullets.push(bullet)
    
    
  stage.update()
    