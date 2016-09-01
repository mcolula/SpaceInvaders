(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.Gun = (function() {
    var color, radius, speed;

    color = "#FFFFFF";

    speed = -10;

    radius = 5;

    Gun.prototype.createView = function(x, y) {
      var circle;
      circle = new createjs.Shape();
      circle.graphics.beginFill("" + color).drawCircle(0, 0, radius);
      circle.x = x;
      circle.y = y;
      return circle;
    };

    function Gun(name, x, y, enemy) {
      this.name = name;
      this.x = x;
      this.y = y;
      this.enemy = enemy;
      this.update = __bind(this.update, this);
      this.createView = __bind(this.createView, this);
      this.view = this.createView(this.x, this.y);
      this.alive = true;
      this.power = 25;
    }

    Gun.prototype.update = function(event) {
      this.y += speed;
      if (this.y <= 0) {
        this.alive = false;
      }
      if (!this.alive) {
        event.remove();
        this.view.visible = false;
      }
      return this.view.y = this.y;
    };

    return Gun;

  })();

}).call(this);

//# sourceMappingURL=gun.js.map
