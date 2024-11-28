document.querySelectorAll('form[id^="formDelete_"]').forEach(form => {
    form.addEventListener('submit', async function (event) {
        event.preventDefault();

        const formData = new FormData(form);
        formData.append('_method', 'DELETE'); // Informar o método DELETE

        try {
            const response = await fetch('http://localhost/TechAcademy4/paginas/validacoes/item/delete_item.php', {
                method: 'POST', // Sempre POST, mas com `_method=DELETE`
                body: formData,
            });

            const result = await response.json();
            if (result.success) {
                alert(result.message);
                form.closest('.conteiner_produto').remove(); // Remove o produto visualmente
            } else {
                alert(`Erro: ${result.message}`);
            }
        } catch (error) {
            console.error(error);
            alert('Erro de conexão com o servidor.');
        }
    });
});
