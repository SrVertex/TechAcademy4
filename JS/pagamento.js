document.getElementById('formPagamento').addEventListener('submit', function(event) {
    const pagamentos = document.querySelectorAll('input[name="pagamento"]');
    const parcelas = document.querySelectorAll('input[name="parcelas"]');
    let pagamentoSelecionado = false;
    let parcelaSelecionada = false;

    pagamentos.forEach(pagamento => {
        if (pagamento.checked) {
            pagamentoSelecionado = true;
            if (pagamento.value === 'creditocard') {
                parcelas.forEach(parcela => {
                    if (parcela.checked) {
                        parcelaSelecionada = true;
                    }
                });
                if (!parcelaSelecionada) {
                    alert('Por favor, selecione uma parcela para o pagamento com cartão de crédito.');
                    event.preventDefault();
                }
            }
        }
    });

    if (!pagamentoSelecionado) {
        alert('Por favor, selecione uma forma de pagamento.');
        event.preventDefault();
    }
});