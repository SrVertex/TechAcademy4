document.getElementById('form').addEventListener('submit', async function(event) {
    event.preventDefault(); // Previne o envio padrão do formulário

    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const response = await fetch('http://localhost:8080/api/usuario/alterar-senha', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email: email,
            senha: senha
        })
    });

    if (response.ok) {
        alert('Senha alterada com sucesso!');
    } else {
        alert('Erro ao alterar a senha. Tente novamente.');
    }
});