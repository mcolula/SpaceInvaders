(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.Stage = (function() {
    var counter, fps, stage;

    stage = void 0;

    counter = 0;

    fps = 60;

    function Stage(name) {
      this.name = name;
      this.update = __bind(this.update, this);
      this.add = __bind(this.add, this);
      stage = new createjs.Stage(this.name);
      stage.snapToPixelsEnabled = true;
      createjs.Ticker.setFPS(fps);
    }

    Stage.prototype.add = function(element) {
      stage.addChildAt(element.view);
      if (element.update) {
        return createjs.Ticker.on("tick", element.update);
      }
    };

    Stage.prototype.update = function() {
      return stage.update();
    };

    return Stage;

  })();

}).call(this);

//# sourceMappingURL=stage.js.map
