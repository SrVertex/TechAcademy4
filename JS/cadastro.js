var FormValidator = /** @class */ (function () {
    function FormValidator() {
        this.form = document.getElementById('form');
        this.campos = document.querySelectorAll('.required');
        this.spans = document.querySelectorAll('.span-required');
        this.emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        this.form.addEventListener('submit', this.handleSubmit.bind(this));
    }
    FormValidator.prototype.setError = function (index) {
        this.campos[index].style.border = '2px solid #e63636';
        this.spans[index].style.display = 'block';
    };
    FormValidator.prototype.removeError = function (index) {
        this.campos[index].style.border = '2px solid #fff';
        this.spans[index].style.display = 'none';
    };
    FormValidator.prototype.emailValidate = function () {
        if (!this.emailRegex.test(this.campos[0].value)) {
            this.setError(0);
        }
        else {
            this.removeError(0);
        }
    };
    FormValidator.prototype.nomeValidate = function () {
        if (this.campos[1].value.length < 3) {
            this.setError(1);
        }
        else {
            this.removeError(1);
        }
    };
    FormValidator.prototype.mainPasswordValidate = function () {
        if (this.campos[2].value.length < 8) {
            this.setError(2);
        }
        else {
            this.removeError(2);
        }
    };
    FormValidator.prototype.mainPasswordValidate2 = function () {
        if (this.campos[3].value.length < 8) {
            this.setError(3);
        }
        else {
            this.removeError(3);
        }
    };
    FormValidator.prototype.handleSubmit = function (event) {
        this.emailValidate();
        this.nomeValidate();
        this.mainPasswordValidate();
        this.mainPasswordValidate2();
        if (!this.emailRegex.test(this.campos[0].value) ||
            this.campos[1].value.length < 3 ||
            this.campos[2].value.length < 8 ||
            this.campos[3].value.length < 8) {
            event.preventDefault();
        }
    };
    return FormValidator;
}());
var validator = new FormValidator();
