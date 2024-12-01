document.getElementById('formCEP').addEventListener('submit', async function(e) {
    e.preventDefault(); // Evita o envio tradicional do formulário

    const cepInput = document.getElementById('cep');
    const cep = cepInput.value.replace(/\D/g, ''); // Remove caracteres não numéricos
    const resultadoDiv = document.getElementById('resultado');

    // Valida o CEP (deve conter exatamente 8 dígitos)
    if (cep.length !== 8) {
        resultadoDiv.innerHTML = '<p style="color:red;">CEP inválido. Insira um CEP com 8 dígitos.</p>';
        return;
    }

    // Exibe mensagem de carregamento
    resultadoDiv.innerHTML = '<p>Buscando informações...</p>';

    try {
        // Envia a requisição para o servidor
        const response = await fetch('https://viacep.com.br/ws/' + cep + '/json', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            } // Envia o CEP no corpo da requisição
        });
        console.log('respondeu o coiso ', response.body);
        const data = await response.json();

        // Verifica se houve erro no backend
        if (data.erro) {
            resultadoDiv.innerHTML = `<p style="color:red;">${data.erro}</p>`;
        } else {
            // Exibe os dados do CEP
            resultadoDiv.innerHTML = `
            <div id="info_cep">
                    <h6>Resultado da busca:</h6>
                <p><strong>Cidade:</strong> ${data.localidade}</p>
                <p><strong>Estado:</strong> ${data.uf}</p>
                <p style="margin-bottom: 0 !important;"><strong>Frete Grátis</strong></p>
            </div>
            `;
        }
    } catch (error) {
        resultadoDiv.innerHTML =
            '<p style="color:red;">Erro ao buscar o CEP. Tente novamente mais tarde.</p>';
    }
});