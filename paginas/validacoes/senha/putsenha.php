
<?php
if ($_SERVER['REQUEST_METHOD'] === 'PUT') {
    if ($dadosProduto) {

        // URL da API que vai receber o PUT
        $url = "http://localhost:8080/api/usuario/alterar-senha";

        // Inicia o cURL
        $ch = curl_init($url);

        // Dados que serão enviados no corpo da requisição PUT
        $postData = json_encode([
            'email' => $dadosProduto['email'],
            'senha' => (float)$dadosProduto['senha']
        ]);

        // Configurações do cURL
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
        curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);
        curl_setopt($ch, CURLOPT_HTTPHEADER, [
            'Content-Type: application/json',
            'Content-Length: ' . strlen($postData)
        ]);

        // Executa a requisição
// Executa a requisição
$response = curl_exec($ch);

// Verifica se houve algum erro na requisição
if(curl_errno($ch)) {
    echo json_encode(['success' => false, 'message' => 'Erro na requisição: ' . curl_error($ch)]);
} else {
    // Verifica o código de status HTTP
    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
    if ($httpCode >= 200 && $httpCode < 300) {
        // Se o código de status for 2xx, é sucesso
        echo json_encode(['success' => true, 'message' => 'Senha altereda com Sucesso']);
    } else {
        // Se o código de status não for 2xx, é erro
        echo json_encode(['success' => false, 'message' => "Erro: Código HTTP $httpCode"]);
    }
}

// Fecha o cURL
curl_close($ch);

    } else {
        echo json_encode(['success' => false, 'message' => 'Dados inválidos']);
    }
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}




