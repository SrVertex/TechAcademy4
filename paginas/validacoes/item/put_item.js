document.getElementById('formProdutoPut').addEventListener('submit', async function (event) {
    event.preventDefault(); // Evita o redirecionamento padrão do formulário

    const form = event.target;
    const formData = new FormData(form);

    // Cria um objeto de dados a partir do FormData
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    try {
        // Envia os dados para o backend via PUT
        const response = await fetch('http://localhost/TechAcademy4/paginas/validacoes/item/put_item.php', {
            method: 'PUT', // Garante que o método é PUT
            headers: {
                'Content-Type': 'application/json', // Envia os dados no formato JSON
            },
            body: JSON.stringify(data), // Envia os dados convertidos para JSON
        });

        const result = await response.json();

        if (result.success) {
            alert(result.message); // Exibe mensagem de sucesso
            location.reload(); // Recarrega a página atual
        } else {
            alert(`Erro: ${result.message}`);
        }
    } catch (error) {
        alert('Erro de conexão com o servidor.');
        console.error(error);
    }
});