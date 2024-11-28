<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $uploadDir = 'uploads/'; // Diretório para armazenar as imagens
    $fotoPost = $_FILES['fotoPost'];

    // Verificar se a imagem foi carregada corretamente
    if ($fotoPost['error'] === UPLOAD_ERR_OK) {
        $fileName = basename($fotoPost['name']);
        $filePath = $uploadDir . $fileName;

        // Mover a imagem para o diretório de uploads
        if (move_uploaded_file($fotoPost['tmp_name'], $filePath)) {
            $link = 'http://localhost:8080/api/item'; // URL da sua API no Spring Boot

            // Captura os dados do formulário enviados via POST
            $dadosProduto = [
                'nome' => $_POST['nomePost'],
                'descricao' => $_POST['descricaoPost'],
                'preco' => (float)$_POST['precoPost'],
                'estoque' => (int)$_POST['estoquePost'],
                'atributo_1' => $_POST['atributo_1Post'],
                'atributo_2' => $_POST['atributo_2Post'],
                'atributo_3' => $_POST['atributo_3Post'],
                'atributo_4' => $_POST['atributo_4Post'],
                'atributo_5' => $_POST['atributo_5Post'],
                'atributo_6' => $_POST['atributo_6Post'],
                'categoria_id' => (int)$_POST['id_categoriaPost']
            ];

            // Converte os dados para JSON
            $dadosJson = json_encode($dadosProduto);

            // Configura o cURL para enviar a requisição POST
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $link);
            curl_setopt($ch, CURLOPT_POST, true);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            curl_setopt($ch, CURLOPT_VERBOSE, true);
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
                    echo json_encode(['success' => true, 'message' => 'Produto criado com sucesso.']);
                } else {
                    echo json_encode(['success' => false, 'message' => 'Erro ao criar produto.', 'response' => $response]);
                }
            }
            curl_close($ch);
        } else {
            echo json_encode(['success' => false, 'message' => 'Falha ao mover o arquivo.']);
        }
    } else {
        echo json_encode(['success' => false, 'message' => 'Erro no upload da imagem.']);
    }
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}
?>
