<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Pegando os dados do formulário
    $id = $_POST['id_item'];
    $nome = $_POST['nome'];
    $descricao = $_POST['descricao'];
    $preco = $_POST['preco'];
    $estoque = $_POST['estoque'];
    $atributo_1 = $_POST['atributo_1'];
    $atributo_2 = $_POST['atributo_2'];
    $atributo_3 = $_POST['atributo_3'];
    $atributo_4 = $_POST['atributo_4'];
    $atributo_5 = $_POST['atributo_5'];
    $atributo_6 = $_POST['atributo_6'];
    $id_categoria = $_POST['id_categoria'];

    // Preparando os dados para enviar
    $data = [
        'nome' => $nome,
        'descricao' => $descricao,
        'preco' => $preco,
        'estoque' => $estoque,
        'atributo_1' => $atributo_1,
        'atributo_2' => $atributo_2,
        'atributo_3' => $atributo_3,
        'atributo_4' => $atributo_4,
        'atributo_5' => $atributo_5,
        'atributo_6' => $atributo_6,
        'id_categoria' => $id_categoria
    ];

    // Convertendo os dados para JSON
    $jsonData = json_encode($data);

    // Definindo a URL da API com o ID
    $url = "http://localhost:8080/api/item/$id"; // Certifique-se de que a URL está correta

    // Inicializando o cURL
    $ch = curl_init($url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT'); // Definindo o método PUT
    curl_setopt($ch, CURLOPT_HTTPHEADER, [
        'Content-Type: application/json',
        'Content-Length: ' . strlen($jsonData),
    ]);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonData); // Enviando os dados no corpo da requisição

    // Executando a requisição
    $response = curl_exec($ch);
    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    // Fechando o cURL
    curl_close($ch);

    // Verificando a resposta
    if ($httpCode === 200) {
        echo "Produto atualizado com sucesso!";
    } else {
        echo "Erro ao atualizar o produto. Código HTTP: $httpCode. Resposta: $response";
    }
} else {
    echo "Requisição inválida.";
}
?>
