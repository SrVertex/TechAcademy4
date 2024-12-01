function carregarDadosProduto() {
    const precoProduto = localStorage.getItem('precoProduto');
    const produtoId = localStorage.getItem('produtoId');
    const linkVoltar = document.getElementById('linkVoltar');


    document.getElementById('produtoPreco').innerText = `Preço: R$ ${precoProduto}`;
    window.precoProduto = precoProduto;
    window.produtoId = produtoId;

    // Chame obterMaxId para buscar o maior ID de pedido
    obterMaxId();
}

function obterMaxId() {
    fetch('http://localhost:8080/api/pedido/maior-id')
        .then(response => response.json())
        .then(data => {
            console.log("Maior ID de pedido:", data);
            // Aqui você pode usar o maior ID conforme necessário
        })
        .catch(error => {
            console.error("Erro ao obter o maior ID de pedido:", error);
        });
}

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
                window.location.href = "cartao";
            } else {
                alert("Pagamento realizado com sucesso!");
                window.location.href = "catao";
            }
        })
        .catch(error => {
            console.error("Erro ao criar pedido:", error);
        });
}

window.onload = carregarDadosProduto;