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
    if (campos[3].value.length < 5) {
        setError(3);
    } else {
        removeError(3);
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