(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.SpaceGun = (function() {
    var color, limit, radius, speed;

    color = "#FFFFAA";

    limit = 600;

    speed = 9;

    radius = 3;

    SpaceGun.prototype.createView = function(x, y) {
      var circle;
      circle = new createjs.Shape();
      circle.graphics.beginFill("" + color).drawCircle(0, 0, radius);
      circle.x = x;
      circle.y = y;
      return circle;
    };

    function SpaceGun(x, y, enemy) {
      this.x = x;
      this.y = y;
      this.enemy = enemy;
      this.update = __bind(this.update, this);
      this.createView = __bind(this.createView, this);
      this.alive = true;
      this.view = this.createView(this.x, this.y);
      this.power = 25;
    }

    SpaceGun.prototype.update = function(event) {
      this.y += speed;
      if (this.y >= limit) {
        this.alive = false;
      }
      if (!this.alive) {
        event.remove();
        this.view.visible = false;
      }
      return this.view.y = this.y;
    };

    return SpaceGun;

  })();

}).call(this);

//# sourceMappingURL=space-gun.js.map
