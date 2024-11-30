<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $link = 'http://localhost:8080/api/usuario/login'; // URL da sua API no Spring Boot

    // Captura os dados do formulário enviados via POST
    $dadosProduto = [
        'email' => $_POST['email'],
        'senha' => (integer)$_POST['senha']
    ];

    // Converte os dados para JSON
    $dadosJson = json_encode($dadosProduto);

    // Configura o cURL para enviar a requisição POST
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $link);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, [
        'Content-Type: application/json',
        'Content-Length: ' . strlen($dadosJson)
    ]);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $dadosJson);

    // Executa a requisição
    $response = curl_exec($ch);

    // Verifica erros no cURL
    if (curl_errno($ch)) {
        echo 'Erro cURL: ' . curl_error($ch);
    } else {
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        if ($httpCode >= 200 && $httpCode < 300) {
            echo json_encode(['success' => true, 'message' => 'Login efetuado com Sucesso!']);
        } else {
            echo json_encode(['success' => false, 'message' => 'Verefique se a senha ou email correto', 'response' => $response]);
        }
    }
    curl_close($ch);
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}
