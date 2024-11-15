const form = document.getElementById("form");
const emailField = document.getElementById("email");
const passwordField = document.getElementById("senha");
const emailError = document.getElementById("email-error");
const passwordError = document.getElementById("senha-error");
const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
function setError(field, error) {
  field.style.border = "2px solid #e63636";
  error.style.display = "block";
}
function removeError(field, error) {
  field.style.border = "2px solid #fff";
  error.style.display = "none";
}
function emailValidate() {
  if (!emailRegex.test(emailField.value)) {
    setError(emailField, emailError);
  } else {
    removeError(emailField, emailError);
  }
}
function mainPasswordValidate() {
  if (passwordField.value.length < 8) {
    setError(passwordField, passwordError);
  } else {
    removeError(passwordField, passwordError);
  }
}
form.addEventListener("submit", function (event) {
  emailValidate();
  mainPasswordValidate();
  if (!emailRegex.test(emailField.value) || passwordField.value.length < 8) {
    event.preventDefault();
  }
});
