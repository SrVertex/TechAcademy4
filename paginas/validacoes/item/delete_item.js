document.getElementById('formDelete').addEventListener('submit', async function (event) {
    event.preventDefault(); // Evita o redirecionamento padrão do formulário

    const form = event.target;
    const formData = new FormData(form);
    
    try {
        const response = await fetch('http://localhost/TechAcademy4/paginas/validacoes/item/delete_item.php', {
            method: 'POST', // Usando POST, mas o conteúdo será tratado como DELETE no PHP
            body: formData, // Envia os dados do formulário
        });

        const result = await response.json();

        if (result.success) {
            alert(result.message);
            location.reload(); // Exibe mensagem de sucesso
        } else {
            alert(`Erro: ${result.message}`);
        }
    } catch (error) {
        alert('Erro de conexão com o servidor.');
        console.error(error);
    }
});
