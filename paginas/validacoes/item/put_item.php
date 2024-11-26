
<?php
if ($_SERVER['REQUEST_METHOD'] === 'PUT') {
    // Lê os dados JSON enviados pelo cliente
    $json = file_get_contents('php://input');
    $dadosProduto = json_decode($json, true);

    if ($dadosProduto) {
        // ID do produto que será atualizado
        $idProduto = $dadosProduto['id_item_put'];

        // URL da API que vai receber o PUT
        $url = "http://localhost:8080/api/item/{$idProduto}";

        // Inicia o cURL
        $ch = curl_init($url);

        // Dados que serão enviados no corpo da requisição PUT
        $postData = json_encode([
            'nome' => $dadosProduto['nome_put'],
            'descricao' => $dadosProduto['descricao_put'],
            'preco' => (float)$dadosProduto['preco_put'],
            'estoque' => (int)$dadosProduto['estoque_put'],
            'atributo_1' => $dadosProduto['atributo_1Post'],
            'atributo_2' => $dadosProduto['atributo_2_put'],
            'atributo_3' => $dadosProduto['atributo_3_put'],
            'atributo_4' => $dadosProduto['atributo_4_put'],
            'atributo_5' => $dadosProduto['atributo_5_put'],
            'atributo_6' => $dadosProduto['atributo_6_put'],
            'categoria_id' => (int)$dadosProduto['id_categoria_put'],
            'foto' => $dadosProduto['foto_put']
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
        $response = curl_exec($ch);

        // Verifica se houve algum erro na requisição
        if(curl_errno($ch)) {
            echo json_encode(['success' => false, 'message' => 'Erro na requisição: ' . curl_error($ch)]);
        } else {
            // Exibe a resposta da API
            echo $response;
        }

        // Fecha o cURL
        curl_close($ch);
    } else {
        echo json_encode(['success' => false, 'message' => 'Dados inválidos']);
    }
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}
