<?php
// Verifica se o método da requisição é POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Obtém os dados enviados pelo formulário
    $email = $_POST['email'] ?? '';
    $senha = $_POST['senha'] ?? '';

    // Verifica se ambos os campos foram preenchidos
    if (empty($email) || empty($senha)) {
        echo "<script>alert('Por favor, preencha todos os campos.'); window.history.back();</script>";
        exit;
    }

    // URL da API para buscar os usuários
    $apiUrl = 'http://localhost:8080/api/usuario';

    // Faz uma requisição para a API e obtém a lista de usuários
    $usuariosJson = file_get_contents($apiUrl);
    $usuarios = json_decode($usuariosJson, true);

    // Verifica se a API retornou os usuários
    if (!is_array($usuarios)) {
        echo "<script>alert('Erro ao se conectar com o servidor.'); window.history.back();</script>";
        exit;
    }

    // Valida o login com os dados recebidos
    $usuarioValido = null;
    foreach ($usuarios as $usuario) {
        // Comparação de e-mail e senha
        if ($usuario['email'] === $email && $usuario['senha'] === $senha) { // Supondo que a senha está sem hash
            $usuarioValido = $usuario;
            break;
        }
    }

    // Verifica se o login foi bem-sucedido
    if ($usuarioValido) {
        // Inicia a sessão e salva os dados do usuário
        session_start();
        $_SESSION['usuario'] = [
            'nome' => $usuarioValido['nome'],
            'email' => $usuarioValido['email']
        ];

        // Redireciona para a página principal
        header('Location: ../../index.php'); // Substitua por sua página de dashboard
        exit;
    } else {
        echo "<script>alert('E-mail ou senha inválidos.'); window.history.back();</script>";
    }
} else {
    // Se o acesso não for por POST, redireciona para a página de login
    header('Location: ../../login.phtml');
    exit;
}
?>
