
document.getElementById('form').addEventListener('submit', async function (event) {
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
        const response = await fetch('http://localhost/TechAcademy4/paginas/validacoes/senha/putsenha.php', {
            method: 'POST', // Garante que o método é PUT
            headers: {
                'Content-Type': 'application/json', // Envia os dados no formato JSON
            },
            body: JSON.stringify(data),// Envia os dados convertidos para JSON
        });

        // Verifica se a resposta foi bem-sucedida (status 200-299)
        if (!response.ok) {
            throw new Error('Erro de conexão com o servidor'); // Lança erro caso a resposta não seja bem-sucedida
        }

        // Tenta obter o JSON da resposta
        const result = await response.json();

                if (result.success) {
                   alert(result.message, window.location.href = "http://localhost/techAcademy4/redefinirSenha"); // Exibe mensagem de sucesso
                    } else {
                        alert(`Erro: ${result.message}`);
                    }
                } catch (error) {
                    alert('Erro de conexão com o servidor.');
                    console.error(error);
                }
            });