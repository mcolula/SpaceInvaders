(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.Bunker = (function() {
    var color, h, w;

    color = "#D3D3D3";

    h = 20;

    w = 80;

    Bunker.prototype.createView = function(x, y) {
      var rect;
      rect = new createjs.Shape();
      rect.graphics.beginFill("" + color).drawRect(x, y, w, h);
      return rect;
    };

    function Bunker(x, y) {
      this.x = x;
      this.y = y;
      this.update = __bind(this.update, this);
      this.inside = __bind(this.inside, this);
      this.collision = __bind(this.collision, this);
      this.gotShot = __bind(this.gotShot, this);
      this.createView = __bind(this.createView, this);
      this.life = 400;
      this.alive = true;
      this.view = this.createView(this.x, this.y);
    }

    Bunker.prototype.gotShot = function(bullet) {
      if (this.collision(bullet)) {
        this.life -= bullet.power;
        return true;
      }
      return false;
    };

    Bunker.prototype.collision = function(that) {
      return this.inside(that.x, that.y);
    };

    Bunker.prototype.inside = function(x, y) {
      return x >= this.x && x <= this.x + w && y >= this.y && y <= this.y + h;
    };

    Bunker.prototype.update = function(event) {
      if (this.life <= 0) {
        this.alive = false;
      }
      if (!this.alive) {
        event.remove();
        return this.view.visible = false;
      }
    };

    return Bunker;

  })();

}).call(this);

//# sourceMappingURL=bunker.js.map
