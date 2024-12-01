function filtrarProdutos() {
    let selectedValues = [];
    let showAll = document.getElementById('valorTodos').checked;

    // Se o "Mostrar Todos" estiver marcado, mostra todos os produtos sem filtro
    if (showAll) {
        // Exibe todos os produtos
        let produtos = document.querySelectorAll('.conteiner_produto');
        produtos.forEach(produto => {
            produto.style.display = 'flex';
        });
        return;
    }

    // Captura todos os checkboxes selecionados, excluindo o "Mostrar Todos"
    document.querySelectorAll('.valorFilter:checked').forEach(checkbox => {
        selectedValues.push(parseFloat(checkbox.getAttribute('data-valor')));
    });

    // Se não houver seleções, exibe todos os produtos
    if (selectedValues.length === 0) {
        let produtos = document.querySelectorAll('.conteiner_produto');
        produtos.forEach(produto => {
            produto.style.display = 'flex';
        });
        return;
    }

    // Filtra os produtos com base nos valores selecionados (preço <= valor selecionado)
    let produtos = document.querySelectorAll('.conteiner_produto');
    produtos.forEach(produto => {
        let precoProduto = parseFloat(produto.getAttribute('data-preco'));
        // Verifica se o preço do produto é menor ou igual ao valor selecionado
        if (selectedValues.some(val => precoProduto <= val)) {
            produto.style.display = 'flex'; // Exibe o produto
        } else {
            produto.style.display = 'none'; // Oculta o produto
        }
    });
}

// Evento para garantir que apenas um checkbox possa ser selecionado de cada vez
document.querySelectorAll('.valorFilter').forEach(checkbox => {
    checkbox.addEventListener('change', function() {
        if (this.checked) {
            // Se um checkbox for marcado, desmarque todos os outros
            document.querySelectorAll('.valorFilter').forEach(otherCheckbox => {
                if (otherCheckbox !== this) {
                    otherCheckbox.checked = false;
                }
            });
        }
        filtrarProdutos();
    });
});