<?php
// Inicia a sessão
session_start();

// Remove os dados da sessão
session_unset();

// Destroi a sessão
session_destroy();

// Redireciona para a página inicial
header('Location: index.php');
exit;
?>
