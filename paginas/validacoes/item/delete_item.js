async function excluirProduto(produto) {
    try {
        const response = await fetch(`http://localhost:8080/api/item/${produto}`, {
            method: 'DELETE'
        });

        
        if(response.status === 200) {
            elementoHtml = document.getElementById(`prod_${produto}`)
            elementoHtml.remove()

            location.reload(); 

        } else {
            alert('Erro de conexão com o servidor.');
        }
        
    } catch (error) {
        alert('Produto Removido');
        console.error(error);
    }
    console.log(produto);
}