
document.addEventListener('DOMContentLoaded', function() {
    carregarDadosProduto();
});

function carregarDadosProduto() {
    const precoProduto = localStorage.getItem('precoProduto');
    const produtoId = localStorage.getItem('produtoId');

    document.getElementById('produtoPreco').innerText = ` R$ ${precoProduto},00`;
    document.getElementById('idproduto').innerText = `${produtoId}`;
    window.precoProduto = precoProduto;
    window.produtoId = produtoId;
    
}

    // função para criar o pedido
function realizarPagamento(event) {
    event.preventDefault();

    const metodoPagamento = document.querySelector('input[name="pagamento"]:checked');
    const parcelaSelecionada = document.querySelector('input[name="parcelas"]:checked');

    if (!metodoPagamento) {
        alert("Por favor, selecione um método de pagamento.");
        return;
    }

    if (metodoPagamento.value === 'creditocard' && !parcelaSelecionada) {
        alert("Por favor, selecione uma parcela.");
        return;
    }


    const pedidoData = {
        valor: window.precoProduto,
        status: 'Pendente',
        data_pedido: new Date().toISOString(),
        produto_id: window.produtoId,
        metodo_pagamento: metodoPagamento.value,
        parcelas: parcelaSelecionada ? parcelaSelecionada.value : null
    };

    // caminho para o banco de dados
    fetch('http://localhost:8080/api/pedido', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(pedidoData)


    })
    .then(response => response.json())
    .then(data => {
        console.log("Pedido criado com sucesso:", data);
        if (metodoPagamento.value === 'creditocard') {
            window.location.href = "catao";
        } else {
            alert("Formar de Pagamento Aprovado!") ;
            window.location.href = "catao";
            obterMaxId();
        }
    })
    .catch(error => {
        console.error("Erro ao criar pedido:", error);
    });

    // busda do maior id do pedido
    function obterMaxId() {
        fetch('http://localhost:8080/api/pedido/maior-id')
            .then(response => response.json())
            .then(data => {
                console.log("Maior ID de pedido:", data);
            })
            .catch(error => {
                console.error("Erro ao obter o maior ID de pedido:", error);
            });
    }
}

