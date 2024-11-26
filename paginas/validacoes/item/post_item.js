document.getElementById('formProduto').addEventListener('submit', async function (event) {
    event.preventDefault(); // Evita o redirecionamento padrão do formulário

    const form = event.target;
    const formData = new FormData(form);

    try {
        const response = await fetch('http://localhost/TechAcademy4/paginas/validacoes/item/post_item.php', {
            method: 'POST', // Garante que o método é POST
            body: formData, // Envia os dados do formulário
        });

        const result = await response.json();

        if (result.success) {
            alert(result.message); // Exibe mensagem de sucesso
        } else {
            alert(`Erro: ${result.message}`);
        }
    } catch (error) {
        alert('Erro de conexão com o servidor.');
        console.error(error);
    }
});
