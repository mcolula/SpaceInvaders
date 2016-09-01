(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  window.Game = (function() {
    var bunkerCount, bunkerWidth, conn, gaming, height, invaderCount, invaderWidth, invadersPerRow, ip, lifeMessage, livesMessage, mainMessage, name, score, scoreMessage, span, surl, width;

    ip = "localhost:9000";

    width = 1000;

    height = 600;

    bunkerCount = 6;

    invaderCount = 24;

    invadersPerRow = 4;

    gaming = true;

    score = 0;

    mainMessage = "";

    scoreMessage = "";

    livesMessage = "";

    lifeMessage = "";

    bunkerWidth = 80;

    invaderWidth = 20;

    span = 40;

    name = prompt("Ingresa tu nickame: ", "");

    surl = "ws://" + ip + "/socket/" + name;

    conn = new WebSocket(surl);

    function Game() {
      this.run = __bind(this.run, this);
      this.updateLabels = __bind(this.updateLabels, this);
      this.gameOverBehavior = __bind(this.gameOverBehavior, this);
      this.gamePassed = __bind(this.gamePassed, this);
      this.invadersGunBehavior = __bind(this.invadersGunBehavior, this);
      this.mainGunBehavior = __bind(this.mainGunBehavior, this);
      this.bindEvents = __bind(this.bindEvents, this);
      this.invaderOffset = __bind(this.invaderOffset, this);
      this.bunkerOffset = __bind(this.bunkerOffset, this);
      this.onError = __bind(this.onError, this);
      this.onOpen = __bind(this.onOpen, this);
      this.onMessage = __bind(this.onMessage, this);
      var bunker, i, invader, x, _i, _j, _k, _l, _len, _len1, _m, _ref, _ref1;
      this.stage = new Stage("canvas");
      this.player = new Player(name, width / 2, height);
      this.stage.add(this.player);
      this.bunkers = [];
      this.invaders = [];
      this.guns = [];
      mainMessage = new TextMessage("Conectando", width * 0.5, height * 0.5, 64);
      scoreMessage = new TextMessage("Score: " + score, width * 0.25, height * 0.1, 32);
      livesMessage = new TextMessage("Lives: " + (this.player.lives + 1), width * 0.5, height * 0.1, 32);
      lifeMessage = new TextMessage("Life: " + this.player.life, width * 0.75, height * 0.1, 32);
      this.stage.add(scoreMessage);
      this.stage.add(livesMessage);
      this.stage.add(lifeMessage);
      for (x = _i = 0; 0 <= bunkerCount ? _i < bunkerCount : _i > bunkerCount; x = 0 <= bunkerCount ? ++_i : --_i) {
        this.bunkers.push(new Bunker(x * (bunkerWidth + this.bunkerOffset()), 0.65 * height));
      }
      _ref = this.bunkers;
      for (_j = 0, _len = _ref.length; _j < _len; _j++) {
        bunker = _ref[_j];
        this.stage.add(bunker);
      }
      for (x = _k = 0; 0 <= invaderCount ? _k < invaderCount : _k > invaderCount; x = 0 <= invaderCount ? ++_k : --_k) {
        this.invaders.push(new Invader(x * (invaderWidth + this.invaderOffset()) + span, 0.30 * height));
      }
      _ref1 = this.invaders;
      for (_l = 0, _len1 = _ref1.length; _l < _len1; _l++) {
        invader = _ref1[_l];
        this.stage.add(invader);
      }
      for (i = _m = 0; 0 <= invaderCount ? _m < invaderCount : _m > invaderCount; i = 0 <= invaderCount ? ++_m : --_m) {
        this.guns.push(void 0);
      }
      if (this.player.name === "mcolula") {
        conn.onopen = this.onOpen;
      } else {
        this.stage.add(mainMessage);
        conn.onmessage = this.onMessage;
        conn.onerror = this.onError;
      }
      this.stage.update();
    }

    Game.prototype.onMessage = function() {
      this.bindEvents(this.stage);
      return mainMessage.alive = false;
    };

    Game.prototype.onOpen = function() {
      conn.send("[start]");
      return this.bindEvents(this.stage);
    };

    Game.prototype.onError = function() {
      return alert("Error: no se pudo establecer la conexión a internet");
    };

    Game.prototype.bunkerOffset = function() {
      var freeSpace;
      freeSpace = width - bunkerWidth * bunkerCount;
      freeSpace /= bunkerCount - 1;
      return freeSpace;
    };

    Game.prototype.invaderOffset = function() {
      var freeSpace;
      freeSpace = width - invaderWidth * invaderCount - 2 * span;
      freeSpace /= invaderCount - 1;
      return freeSpace;
    };

    Game.prototype.bindEvents = function(stage) {
      document.onkeydown = this.player.onKeyDown;
      document.onkeyup = this.player.onKeyUp;
      createjs.Ticker.on('tick', stage.update);
      return createjs.Ticker.on('tick', this.run);
    };

    Game.prototype.mainGunBehavior = function() {
      var bunker, invader, _i, _j, _len, _len1, _ref, _ref1, _results;
      if ((this.gun != null) && !this.gun.alive) {
        this.gun = void 0;
      }
      if (this.player.alive && this.player.shooting() && (this.gun == null)) {
        this.gun = this.player.shoot();
        this.stage.add(this.gun);
      }
      _ref = this.bunkers;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        bunker = _ref[_i];
        if ((this.gun != null) && bunker.alive && bunker.gotShot(this.gun)) {
          this.gun.alive = false;
        }
      }
      _ref1 = this.invaders;
      _results = [];
      for (_j = 0, _len1 = _ref1.length; _j < _len1; _j++) {
        invader = _ref1[_j];
        if ((this.gun != null) && invader.alive && invader.gotShot(this.gun)) {
          this.gun.alive = false;
          _results.push(score += 100);
        } else {
          _results.push(void 0);
        }
      }
      return _results;
    };

    Game.prototype.invadersGunBehavior = function() {
      var bunker, i, _i, _j, _k, _l, _len, _m, _ref, _results;
      for (i = _i = 0; 0 <= invaderCount ? _i < invaderCount : _i > invaderCount; i = 0 <= invaderCount ? ++_i : --_i) {
        if ((this.guns[i] != null) && !this.guns[i].alive) {
          this.guns[i] = void 0;
        }
      }
      for (i = _j = 0; 0 <= invaderCount ? _j < invaderCount : _j > invaderCount; i = 0 <= invaderCount ? ++_j : --_j) {
        if ((this.guns[i] == null) && this.invaders[i].shooting()) {
          this.guns[i] = this.invaders[i].shoot();
          this.stage.add(this.guns[i]);
        }
      }
      for (i = _k = 0; 0 <= invaderCount ? _k < invaderCount : _k > invaderCount; i = 0 <= invaderCount ? ++_k : --_k) {
        if (this.guns[i] != null) {
          _ref = this.bunkers;
          for (_l = 0, _len = _ref.length; _l < _len; _l++) {
            bunker = _ref[_l];
            if (bunker.alive && bunker.gotShot(this.guns[i])) {
              this.guns[i].alive = false;
            }
          }
        }
      }
      _results = [];
      for (i = _m = 0; 0 <= invaderCount ? _m < invaderCount : _m > invaderCount; i = 0 <= invaderCount ? ++_m : --_m) {
        if ((this.guns[i] != null) && this.player.alive && this.player.gotShot(this.guns[i])) {
          _results.push(this.guns[i].alive = false);
        } else {
          _results.push(void 0);
        }
      }
      return _results;
    };

    Game.prototype.gamePassed = function() {
      var invader, _i, _len, _ref;
      _ref = this.invaders;
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        invader = _ref[_i];
        if (invader.alive) {
          return;
        }
      }
      return this.player.alive = false;
    };

    Game.prototype.gameOverBehavior = function() {
      if (!this.player.alive && gaming) {
        gaming = false;
        conn.send("[" + name + "][score]" + score);
        return window.location = "http://" + ip + "/score/" + name;
      }
    };

    Game.prototype.updateLabels = function() {
      scoreMessage.view.text = "Score: " + score;
      livesMessage.view.text = "Lives: " + (this.player.lives + 1);
      return lifeMessage.view.text = "Life: " + this.player.life;
    };

    Game.prototype.run = function() {
      this.gameOverBehavior();
      this.gamePassed();
      this.updateLabels();
      this.mainGunBehavior();
      return this.invadersGunBehavior();
    };

    return Game;

  })();

  this.init = function() {
    var game;
    return game = new Game();
  };

}).call(this);

//# sourceMappingURL=game.js.map
