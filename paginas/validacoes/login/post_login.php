<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $link = 'http://localhost:8080/api/usuario/login'; // URL da sua API no Spring Boot para login

    // Captura os dados do formulário enviados via POST
    $dadosLogin = [
        'email' => $_POST['email'],
        'senha' => $_POST['senha'],  // Alterei para string, pois é assim que estamos comparando no Spring Boot
    ];

    // Converte os dados para JSON
    $dadosJson = json_encode($dadosLogin);

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
            echo json_encode(['success' => true, 'message' => 'Login bem-sucedido.', 'response' => $response]);
        } else {
            echo json_encode(['success' => false, 'message' => 'Erro ao realizar login.', 'response' => $response]);
        }
    }
    curl_close($ch);
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}

