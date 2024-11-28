<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['_method']) && $_POST['_method'] === 'DELETE') {
    $idProduto = isset($_POST['idProdutoDelete']) ? (int)$_POST['idProdutoDelete'] : null;

    // Log do ID para debug
    file_put_contents('debug.log', "ID recebido para DELETE: $idProduto" . PHP_EOL, FILE_APPEND);

    if (!$idProduto) {
        echo json_encode(['success' => false, 'message' => 'ID do produto não fornecido.']);
        exit;
    }

    $link = 'http://localhost:8080/api/item/' . $idProduto;

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $link);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'DELETE');
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $response = curl_exec($ch);

    file_put_contents('debug.log', "Resposta da API: $response" . PHP_EOL, FILE_APPEND);
    
    if ($response === false) {
        echo json_encode(['success' => false, 'message' => 'Erro cURL: ' . curl_error($ch)]);
    } else {
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        file_put_contents('debug.log', "HTTP Code: $httpCode" . PHP_EOL, FILE_APPEND);
    
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



?>
