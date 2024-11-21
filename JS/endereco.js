const form = document.getElementById("form");
const campos = document.querySelectorAll(".required");
const spans = document.querySelectorAll(".span-required");
const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
// aidção da mensagem de erro
function setError(index) {
  campos[index].style.border = "2px solid #e63636";
  spans[index].style.display = "block";
}
//remoção da menssagem de erro
function removeError(index) {
  campos[index].style.border = "2px solid #fff";
  spans[index].style.display = "none";
}

// validação do nome
function nomeEnderecoValidate() {
  if (campos[1].value.length < 5) {
    setError(1);
  } else {
    removeError(1);
  }
}

// validação da senha
function CEPValidate() {
  if (campos[1].value.length < 8) {
    setError(1);
  } else {
    removeError(1);
  }
}

function cidadeValidate() {
  if (campos[5].value.trim() === "") {
    setError(5);
  } else {
    removeError(5);
  }
}
