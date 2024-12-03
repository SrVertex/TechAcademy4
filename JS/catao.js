// Função para finalizar a compra e adicionar o item ao pedido
function finalizarCompra(event) {
    event.preventDefault();

    // Recuperando id do produto e realiza um post para o o item_pedido
    const produtoId = localStorage.getItem('produtoId');

    // recebe o id do produto para o item_pedido
    const itemPedidoData = {
        item_id: produtoId,
    };

    // caminho pra o post de ItemPedido
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
        alert("Compra finalizada com sucesso!");
        window.location.href = "home";  // Página de sucesso
    })
    .catch(error => {
        console.error("Erro ao adicionar item ao pedido:", error);
        alert("Ocorreu um erro ao finalizar a compra. Tente novamente.");
    });
}

