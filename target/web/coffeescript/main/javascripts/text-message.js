(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.TextMessage = (function() {
    var color;

    color = "#FFFFFF";

    TextMessage.prototype.createView = function(message, x, y, size) {
      var text;
      text = new createjs.Text(message, "" + size + "px Arial", color);
      text.textBaseline = "alphabetic";
      text.x = x - text.getMeasuredWidth() * 0.5;
      text.y = y;
      return text;
    };

    function TextMessage(text, x, y, size) {
      this.text = text;
      this.x = x;
      this.y = y;
      this.size = size;
      this.update = __bind(this.update, this);
      this.createView = __bind(this.createView, this);
      this.view = this.createView(this.text, this.x, this.y, this.size);
      this.alive = true;
    }

    TextMessage.prototype.update = function(event) {
      if (!this.alive) {
        event.remove();
        return this.view.visible = false;
      }
    };

    return TextMessage;

  })();

}).call(this);

//# sourceMappingURL=text-message.js.map
