async function excluirProduto(produto) {
    try {
        const response = await fetch(`http://localhost:8080/api/item/${produto}`, {
            method: 'DELETE'
        });

        
        if(response.status === 200) {
            elementoHtml = document.getElementById(`prod_${produto}`)
            elementoHtml.remove();
            
            
        } else {
            alert('delede Concluda');        
        }
        
    } catch (error) {
        alert('Solictação Concluda');
        console.error(error);
    }
    console.log(produto);
}