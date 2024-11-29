document.getElementById('formEndereco').addEventListener('submit', async function (event) {
    event.preventDefault(); // Evita o redirecionamento padrão do formulário

    const form = event.target;
    const formData = new FormData(form);

    try {
        const response = await fetch('http://localhost/TechAcademy4/paginas/validacoes/endereco/post_endereco.php', {
            method: 'POST', // Garante que o método é POST
            body: formData, // Envia os dados do formulário
        });

        const result = await response.json();

        if (result.success) {
            alert(result.message, window.location.href = "http://localhost/techAcademy4/index.php"); // Exibe mensagem de sucesso
        } else {
            alert(`Erro: ${result.message}`);
        }
    } catch (error) {
        alert('Erro de conexão com o servidor.');
        console.error(error);
    }
});


