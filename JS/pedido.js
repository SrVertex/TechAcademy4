 // Função para gerenciar a seleção de checkboxes e envio de formulário
 document.querySelectorAll('form[id^="formStatus_"]').forEach((form) => {
    // Impedir múltiplas seleções de checkboxes no mesmo formulário
    const checkboxes = form.querySelectorAll('input[name="status"]');
    checkboxes.forEach((checkbox) => {
        checkbox.addEventListener("change", () => {
            checkboxes.forEach((box) => {
                if (box !== checkbox) box.checked = false; // Desmarca outras checkboxes
            });
        });
    });

    // Adicionar envio assíncrono ao formulário
    form.addEventListener("submit", async function (event) {
        event.preventDefault(); // Evita o comportamento padrão do formulário

        const formData = new FormData(form);
        const idPedido = formData.get("idPedido");
        const statusSelecionado = formData.get("status");

        // Validação dos campos
        if (!idPedido) {
            alert("ID do pedido não encontrado. Verifique o formulário.");
            return;
        }

        if (!statusSelecionado) {
            alert("Por favor, selecione um status.");
            return;
        }

        // Desabilitar o botão de envio para evitar múltiplos envios
        const submitButton = form.querySelector('button[type="submit"]');
        if (submitButton) submitButton.disabled = true;

        try {
            const response = await fetch(`http://localhost:8080/api/pedido/${idPedido}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    status: statusSelecionado,
                }),
            });

            const result = await response.json();
            if (response.ok) {
                alert(result.message || "Status do pedido atualizado com sucesso."), location.reload();
                // Opcional: Atualizar a interface do usuário, se necessário
            } else {
                alert(`Erro ${response.status}: ${result.message || "Não foi possível atualizar o status."}`);
            }
        } catch (error) {
            console.error(error);
            alert("Erro ao conectar ao servidor. Verifique sua conexão.");
        } finally {
            // Reabilitar o botão de envio
            if (submitButton) submitButton.disabled = false;
        }
    });
});