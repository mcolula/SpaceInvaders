(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.Player = (function() {
    var color, limit, radius, speed;

    speed = 3;

    radius = 25;

    limit = 1000;

    color = "#00BFFF";

    Player.prototype.createView = function(x, y) {
      var circle;
      circle = new createjs.Shape();
      circle.graphics.beginFill("" + color).drawCircle(0, 0, radius);
      circle.x = x;
      circle.y = y;
      return circle;
    };

    function Player(name, x, y) {
      this.name = name;
      this.x = x;
      this.y = y;
      this.inside = __bind(this.inside, this);
      this.collision = __bind(this.collision, this);
      this.gotShot = __bind(this.gotShot, this);
      this.shoot = __bind(this.shoot, this);
      this.shooting = __bind(this.shooting, this);
      this.update = __bind(this.update, this);
      this.onKeyUp = __bind(this.onKeyUp, this);
      this.onKeyDown = __bind(this.onKeyDown, this);
      this.createView = __bind(this.createView, this);
      this.id = void 0;
      this.lives = 1;
      this.life = 100;
      this.alive = true;
      this.view = this.createView(this.x, this.y);
      this.controls = {
        pressingL: false,
        pressingR: false,
        pressingShoot: false,
        pressingSpeed: false
      };
    }

    Player.prototype.onKeyDown = function(event) {
      if (event.keyCode === 37) {
        this.controls.pressingL = true;
        this.controls.pressingR = false;
      }
      if (event.keyCode === 39) {
        this.controls.pressingL = false;
        this.controls.pressingR = true;
      }
      if (event.keyCode === 32) {
        this.controls.pressingShoot = true;
      }
      if (event.keyCode === 16) {
        return this.controls.pressingSpeed = true;
      }
    };

    Player.prototype.onKeyUp = function(event) {
      if (event.keyCode === 37) {
        this.controls.pressingL = false;
      }
      if (event.keyCode === 39) {
        this.controls.pressingR = false;
      }
      if (event.keyCode === 32) {
        this.controls.pressingShoot = false;
      }
      if (event.keyCode === 16) {
        return this.controls.pressingSpeed = false;
      }
    };

    Player.prototype.update = function(event) {
      if (this.life <= 0 && this.lives >= 1) {
        this.lives -= 1;
        this.life = 100;
      }
      if (this.life <= 0 && this.lives < 1) {
        this.alive = false;
      }
      if (this.controls.pressingR) {
        this.x += speed;
        if (this.x > limit) {
          this.x = limit;
        }
      }
      if (this.controls.pressingL) {
        this.x -= speed;
        if (this.x < 0) {
          this.x = 0;
        }
      }
      if (this.controls.pressingSpeed) {
        speed = 8;
      } else {
        speed = 3;
      }
      if (!this.alive) {
        event.remove();
        this.view.visible = false;
      }
      this.view.x = this.x;
      return this.view.y = this.y;
    };

    Player.prototype.shooting = function() {
      return this.controls.pressingShoot;
    };

    Player.prototype.shoot = function() {
      return new Gun(this.name, this.x, this.y - radius, false);
    };

    Player.prototype.gotShot = function(bullet) {
      if (this.collision(bullet) && bullet.enemy) {
        this.life -= bullet.power;
        return true;
      }
      return false;
    };

    Player.prototype.collision = function(that) {
      return this.inside(that.x, that.y);
    };

    Player.prototype.inside = function(x, y) {
      return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= radius;
    };

    return Player;

  })();

}).call(this);

//# sourceMappingURL=player.js.map
