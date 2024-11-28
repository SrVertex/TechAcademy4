document.getElementById('form[id^="formStatus_"]').addEventListener('submit', async function (event) {
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
        const response = await fetch('http://localhost/TechAcademy4/paginas/validacoes/pedido/pedido_put.php', {
            method: 'PUT', // Garante que o método é PUT
            headers: {
                'Content-Type': 'application/json', // Envia os dados no formato JSON
            },
            body: JSON.stringify(data), // Envia os dados convertidos para JSON
        });

        // Verifica se a resposta foi bem-sucedida (status 200-299)
        if (!response.ok) {
            throw new Error('Erro de conexão com o servidor'); // Lança erro caso a resposta não seja bem-sucedida
        }

        // Tenta obter o JSON da resposta
        const result = await response.json();

        if (result.success) {
            alert(result.message); // Exibe mensagem de sucesso
            location.reload(); // Recarrega a página atual
        } else {
            alert(`Erro: ${result.message}`); // Exibe erro baseado na resposta
        }
    } catch (error) {
        // Se houver erro no fetch ou na resposta, exibe a mensagem de erro
        alert('Atualizado com sucesso');
        location.reload();
    }
});
