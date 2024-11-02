var Greeter = /** @class */ (function () {
    function Greeter() {
    }
    Greeter.prototype.greet = function () {
        console.log("Hello, World!");
    };
    return Greeter;
}());
var apresentar = new Greeter();
apresentar.greet();
