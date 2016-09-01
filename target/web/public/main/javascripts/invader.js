(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.Invader = (function() {
    var color, h, shootProbability, w;

    shootProbability = 0.02;

    color = "#DD0A0A";

    h = 20;

    w = 20;

    Invader.prototype.createView = function(x, y) {
      var rect;
      rect = new createjs.Shape();
      rect.graphics.beginFill("" + color).drawRect(x, y, w, h);
      return rect;
    };

    function Invader(x, y) {
      this.x = x;
      this.y = y;
      this.inside = __bind(this.inside, this);
      this.collision = __bind(this.collision, this);
      this.gotShot = __bind(this.gotShot, this);
      this.shoot = __bind(this.shoot, this);
      this.shooting = __bind(this.shooting, this);
      this.update = __bind(this.update, this);
      this.createView = __bind(this.createView, this);
      this.lives = 0;
      this.life = 100;
      this.alive = true;
      this.view = this.createView(this.x, this.y);
    }

    Invader.prototype.update = function(event) {
      if (this.life <= 0 && this.lives >= 1) {
        this.lives -= 1;
        this.life = 5;
      }
      if (this.life <= 0 && this.lives < 1) {
        this.alive = false;
      }
      if (!this.alive) {
        event.remove();
        return this.view.visible = false;
      }
    };

    Invader.prototype.shooting = function() {
      if (this.alive) {
        return Math.random() <= shootProbability;
      } else {
        return false;
      }
    };

    Invader.prototype.shoot = function() {
      return new SpaceGun(this.x + w / 2, this.y + h, true);
    };

    Invader.prototype.gotShot = function(bullet) {
      if (this.collision(bullet) && !bullet.enemy) {
        this.life -= bullet.power;
        return true;
      }
      return false;
    };

    Invader.prototype.collision = function(that) {
      return this.inside(that.x, that.y);
    };

    Invader.prototype.inside = function(x, y) {
      return x >= this.x && x <= this.x + w && y >= this.y && y <= this.y + h;
    };

    return Invader;

  })();

}).call(this);

//# sourceMappingURL=invader.js.map
