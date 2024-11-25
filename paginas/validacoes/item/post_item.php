<?php
// Configuração do cabeçalho para tratar erros
header("Content-Type: application/json");

// Verifica se o método da requisição é POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Captura os dados do formulário
    $data = [
        'nome' => $_POST['nome'],
        'descricao' => $_POST['descricao'],
        'preco' => (float)$_POST['preco'],
        'estoque' => (int)$_POST['estoque'],
        'atributo_1' => $_POST['atributo_1'],
        'atributo_2' => $_POST['atributo_2'],
        'atributo_3' => $_POST['atributo_3'],
        'atributo_4' => $_POST['atributo_4'],
        'atributo_5' => $_POST['atributo_5'],
        'atributo_6' => $_POST['atributo_6'],
        'id_categoria' => (int)$_POST['id_categoria'],
    ];

    // Converte os dados para JSON
    $jsonData = json_encode($data);

    // Configura a URL da API
    $url = 'http://localhost:8080/api/item';

    // Configura o cURL para enviar o POST
    $ch = curl_init($url);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
    curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonData);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, [
        'Content-Type: application/json',
        'Content-Length: ' . strlen($jsonData),
    ]);

    // Executa a requisição e captura a resposta
    $response = curl_exec($ch);
    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    // Fecha o cURL
    curl_close($ch);

    // Verifica o código de resposta HTTP
    if ($httpCode >= 200 && $httpCode < 300) {
        echo json_encode([
            'success' => true,
            'message' => 'Produto adicionado com sucesso!',
            'response' => json_decode($response, true),
        ]);
    } else {
        echo json_encode([
            'success' => false,
            'message' => 'Erro ao adicionar produto.',
            'response' => json_decode($response, true),
        ]);
    }
} else {
    echo json_encode([
        'success' => false,
        'message' => 'Método inválido. Use POST.',
    ]);
}
?>
