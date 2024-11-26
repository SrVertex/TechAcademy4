<?php

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $link = 'http://localhost:8080/api/item'; // Certifique-se de que a URL está correta

    $nome = $_POST['nomePost'];
    $descricao = $_POST['descricaoPost'];
    $preco = $_POST['precoPost'];
    $estoque = $_POST['estoquePost'];
    $atributo_1 = $_POST['atributo_1Post'];
    $atributo_2 = $_POST['atributo_2Post'];
    $atributo_3 = $_POST['atributo_3Post'];
    $atributo_4 = $_POST['atributo_4Post'];
    $atributo_5 = $_POST['atributo_5Post'];
    $atributo_6 = $_POST['atributo_6Post'];
    $categoria_id = $_POST['id_categoriaPost'];
    $foto = $_POST['fotoPost'];

    $dadosProduto = [
        'nome' => $nome,
        'descricao' => $descricao,
        'preco' => (float)$preco,
        'estoque' => (int)$estoque,
        'foto' => $foto,
        'atributo_1' => $atributo_1,
        'atributo_2' => $atributo_2,
        'atributo_3' => $atributo_3,
        'atributo_4' => $atributo_4,
        'atributo_5' => $atributo_5,
        'atributo_6' => $atributo_6,
        'categoria_id' => (int)$categoria_id
        // 'categoria' => [
        //     'id_categoria' => (int)$categoria_id,
        //     // Removido os valores padrão para evitar problemas com a API.
        // ]
    ];

    $dadosJson = json_encode($dadosProduto);

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $link);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_TIMEOUT, 30);
    curl_setopt($ch, CURLOPT_HTTPHEADER, [
        'Content-Type: application/json',
        'Content-Length: ' . strlen($dadosJson)
    ]);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $dadosJson);

    $response = curl_exec($ch);

    if (curl_errno($ch)) {
        echo 'Erro cURL: ' . curl_error($ch);
    } else {
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

        if ($httpCode >= 200 && $httpCode < 300) {
            echo '<p>Produto criado com sucesso: ' . $response . '</p>';
        } else {
            echo '<p>Erro ao criar produto. Código HTTP: ' . $httpCode . '. Resposta: ' . $response . '</p>';
        }
    }
    curl_close($ch);
}

?>



