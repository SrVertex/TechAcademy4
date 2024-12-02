// Função para finalizar a compra e adicionar o item ao pedido
function finalizarCompra(event) {
    event.preventDefault();

    // Recuperando o ID do produto armazenado no localStorage
    const produtoId = localStorage.getItem('produtoId');

    // Criar o objeto com o ID do pedido e o ID do produto
    const itemPedidoData = {
        item_id: produtoId,
    };

    // Enviar os dados para o backend (POST para adicionar o item ao pedido)
    fetch('http://localhost:8080/api/ItemPedido', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(itemPedidoData)
    })
    .then(response => response.json())
    .then(data => {
        console.log("Item adicionado ao pedido com sucesso:", data);
        // Mostrar alerta de sucesso
        alert("Compra finalizada com sucesso!");
        // Redireciona para a página de confirmação ou sucesso
        window.location.href = "home";  // Página de sucesso
    })
    .catch(error => {
        console.error("Erro ao adicionar item ao pedido:", error);
        // Mostrar alerta de erro
        alert("Ocorreu um erro ao finalizar a compra. Tente novamente.");
    });
}

