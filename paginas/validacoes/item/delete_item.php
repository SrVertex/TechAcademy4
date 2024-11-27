<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Captura o ID do produto a ser excluído
    $idProduto = isset($_POST['idProdutoDelete']) ? (int)$_POST['idProdutoDelete'] : null;

    if (!$idProduto) {
        echo json_encode(['success' => false, 'message' => 'ID do produto não fornecido.']);
        exit;
    }

    // URL da API para DELETE
    $link = 'http://localhost:8080/api/item/' . $idProduto;

    // Configura o cURL para enviar a requisição DELETE
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $link);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'DELETE'); // Define o método como DELETE
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    // Executa a requisição
    $response = curl_exec($ch);

    // Verifica se ocorreu algum erro
    if (curl_errno($ch)) {
        echo json_encode(['success' => false, 'message' => 'Erro cURL: ' . curl_error($ch)]);
    } else {
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

        // Verifica o código de resposta da API
        if ($httpCode >= 200 && $httpCode < 300) {
            echo json_encode(['success' => true, 'message' => 'Produto excluído com sucesso.']);
        } else {
            echo json_encode([
                'success' => false,
                'message' => 'Erro ao excluir produto.',
                'http_code' => $httpCode,
                'response' => $response
            ]);
        }
    }

    curl_close($ch);
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}


// Logando o ID recebido
file_put_contents('debug.log', "ID recebido: " . $idProduto . PHP_EOL, FILE_APPEND);

// Logando a URL chamada
file_put_contents('debug.log', "URL chamada: " . $link . PHP_EOL, FILE_APPEND);



?>
