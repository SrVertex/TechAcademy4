async function excluirProduto(produto) {
    try {
        const response = await fetch(`http://localhost:8080/api/item/${produto}`, {
            method: 'DELETE'
        });

        
        if(response.status === 200) {
            elementoHtml = document.getElementById(`prod_${produto}`)
            elementoHtml.remove()
            
            
        } else {
            alert('Erro de conexão com o servidor adas.', location.reload());
        }
        
    } catch (error) {
        alert('Erro de conexão com o servidor.');
        console.error(error);
    }
    console.log(produto);
}