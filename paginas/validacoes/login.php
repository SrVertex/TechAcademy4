<?php
session_start(); // Inicia a sessão no início do script

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Sanitiza os dados recebidos do formulário para evitar XSS
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_EMAIL);
    $senha = filter_input(INPUT_POST, 'senha', FILTER_SANITIZE_STRING);

    // Verifica se ambos os campos foram preenchidos
    if (empty($email) || empty($senha)) {
        echo "<script>alert('Por favor, preencha todos os campos.'); window.history.back();</script>";
        exit;
    }

    // URL da API para buscar os usuários
    $apiUrl = 'http://localhost:8080/api/usuario';

    // Faz uma requisição para a API
    $usuariosJson = @file_get_contents($apiUrl);
    if ($usuariosJson === false) {
        echo "<script>alert('Erro ao se conectar com o servidor.'); window.history.back();</script>";
        exit;
    }

    $usuarios = json_decode($usuariosJson, true);

    // Verifica se a API retornou os usuários
    if (!is_array($usuarios)) {
        echo "<script>alert('Erro ao processar os dados do servidor.'); window.history.back();</script>";
        exit;
    }

    // Valida o login com os dados recebidos
    $usuarioValido = null;
    foreach ($usuarios as $usuario) {
        // Comparação de e-mail e senha (senha precisa estar protegida em produção)
        if ($usuario['email'] === $email && $usuario['senha'] === $senha) {
            $usuarioValido = $usuario;
            break;
        }
    }

    // Verifica se o login foi bem-sucedido
    if ($usuarioValido) {
        // Salva os dados do usuário na sessão
        $_SESSION['usuario'] = [
            'nome' => $usuarioValido['nome'],
            'email' => $usuarioValido['email']
        ];

        // Redireciona para a página principal
        header('Location: ../index.php'); // Ajuste para o caminho correto
        exit;
    } else {
        echo "<script>alert('E-mail ou senha inválidos.'); window.history.back();</script>";
    }
} else {
    // Redireciona para a página de login caso o método não seja POST
    header('Location: ../login.phtml'); // Ajuste para o caminho correto
    exit;
}
?>
