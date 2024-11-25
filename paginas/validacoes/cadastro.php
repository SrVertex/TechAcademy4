<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];

    // Dados do novo usuário
    $novoUsuario = [
        'nome' => $nome,
        'email' => $email,
        'senha' => $senha
    ];

    // Chamada da API para cadastrar o usuário
    $apiUrl = 'http://localhost:8080/api/usuarios';
    $options = [
        'http' => [
            'header'  => "Content-type: application/json\r\n",
            'method'  => 'POST',
            'content' => json_encode($novoUsuario),
        ]
    ];
    $context = stream_context_create($options);
    $response = file_get_contents($apiUrl, false, $context);

    if ($response) {
        echo "Cadastro realizado com sucesso!";
    } else {
        echo "Erro ao cadastrar usuário.";
    }
}
?>
