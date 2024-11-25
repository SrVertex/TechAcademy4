<?php
session_start(); // Inicia a sessão no início do arquivo
$usuarioLogado = isset($_SESSION['usuario']); // Verifica se o usuário está logado
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <title>TECNOLO</title>

    <base href="http://localhost/techAcademy4/">
    <link rel="stylesheet" href="css/style.css">

    <link rel="shortcut icon" href="imagens/logo/logo.png" type="image/x-icon">

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <link rel="stylesheet" href="icons//font///bootstrap-icons.min.css">


    <!-- Inclua o CSS do Flickity -->
    <link rel="stylesheet" href="css/flickity.min.css">
    <!-- Inclua o JavaScript do Flickity -->
    <script src="JS/flickity-docs.min.js"></script>

    <!-- Inclua o CSS do AOS MASTER -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

    <!-- <style>
        .alert {
            background-color: #f8d7da !important;
            color: #721c24;
            padding: 10px;
            margin-top: 10px;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
        }

    </style> -->

</head>

<body>

    <header>

        <div class="nav_mobile">
            <nav class="navbar navbar-expand-lg bg-body-tertiary  z-3 position-absolute">
                <div class="container-fluid">

                    <div class="logo">

                        <a href="index.php"><img src="imagens//logo///logo.png" alt></a>
                        <a class="navbar-brand nome_logo" href="index.php">TECNOLO</a>

                    </div>

                    <div class="barra_pesquisa">
                        <form role="search" action="paginasProdutos/pesquisa" method="post">
                            <input class="2" type="search" placeholder="Digite o que você procura..." aria-label="Search">
                            <button><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-short" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8" />
                                </svg></button>
                        </form>
                    </div>

                    <div class="area_botao">
                        <a href=""><i class="bi bi-moon-stars-fill"></i></a>
                        <a href=""><i class="bi bi-universal-access-circle"></i></a>
                        <a href="carrinho.php"><i class="bi bi-cart"></i></a>

                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                    </div>

                </div>

                <form class="d-flex" role="search" action="paginasProdutos/pesquisa" method="post">
                    <input class="2" type="search" placeholder="Digite o que você procura..." aria-label="Search">
                    <button><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-short" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8" />
                        </svg></button>
                </form>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto mb-2 mb-lg-0">

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Menu
                            </a>

                            <ul class="dropdown-menu dropdown-menu-1 ">
                                <li><a class="dropdown-item" href="#"><i class="bi bi-cart"></i>Carrinho</a></li>
                                <li><a class="dropdown-item" href="#"><i class="bi bi-bag-fill"></i>Meus Pedidos</a></li>
                                <li><a class="dropdown-item" href="#"><i class="bi bi-whatsapp"></i>WhatzApp</a></li>
                                <li><a class="dropdown-item" href="admin"><i class="bi bi-xbox"></i>Admistrador</a></li>
                                <li><a class="dropdown-item" href="endereco"><i class="bi bi-house-door-fill"></i>Meu Endereço</a></li>
                        </li>
                    </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Categorias
                        </a>

                        <ul class="dropdown-menu dropdown-menu-2 ">
                            <li><a class="dropdown-item" href="Notebook">Notebook</a></li>
                            <li><a class="dropdown-item" href="Smartphones">Smartphone</a></li>
                            <li><a class="dropdown-item" href="Acessorios">Acessórios</a></li>
                            <li><a class="dropdown-item" href="Monitor">Monitor</a></li>
                            <li><a class="dropdown-item" href="Games">Games</a></li>
                            <li><a class="dropdown-item" href="Hardware">Hardware</a></li>
                        </ul>
                    </li>



                    </ul>

                    <ul>
                <?php if ($usuarioLogado): ?>
                    <li>Bem-vindo, <?php echo htmlspecialchars($_SESSION['usuario']['nome']); ?>!</li>
                    <li><a href="logout.php">Sair</a></li>
                <?php else: ?>
                    <li><a href="login.php">Entrar</a></li>
                    <li><a href="cadastro.php">Cadastrar</a></li>
                <?php endif; ?>
            </ul>


                    <div class="login">
                        <div class="icon">
                            <a href="login"><i class="bi bi-person-circle"></i></a>
                        </div>

                        <div class="link">
                            <a href="login">Entrar ou</a>

                            <a href="cadastro">Cadastrar-se</a>
                        </div>

                    </div>
                </div>

            </nav>

        </div>

        <div class="nav_desk">
            <nav class="navbar navbar-expand-lg bg-body-tertiary  z-3 position-absolute">
                <div class="navbar_top">

                    <div class="logo">

                        <a href="index.php"><img src="imagens//logo///logo.png"></a>
                        <a class="navbar-brand nome_logo" href="index.php">TECNOLO</a>
                    </div>

                    <div class="barra_pesquisa">
                        <form class="d-flex" role="search" action="paginasProdutos/pesquisa" method="post">
                            <input class="2" type="search" placeholder="Digite o que você procura..." aria-label="Search">
                            <button><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-short" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8" />
                                </svg></button>
                        </form>
                    </div>

                    <div class="login">
                        <div class="icon">
                            <a href="login"><i class="bi bi-person-circle"></i></a>
                        </div>

                        <div class="link">
                            <a href="login">ENTRAR ou</a>

                            <a href="cadastro">CADASTRAR-SE</a>
                        </div>

                    </div>

                    <div class="menu_drop">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle btn-grad" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Menu
                            </button>

                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#"><i class="bi bi-cart"></i>Carrinho</a></li>
                                <li><a class="dropdown-item" href="#"><i class="bi bi-bag-fill"></i>Meus Pedidos</a>
                                </li>
                                <li><a class="dropdown-item" href="#"><i class="bi bi-whatsapp"></i>WhatzApp</a></li>
                                <li><a class="dropdown-item" href="endereco"><i class="bi bi-house-door-fill"></i>Meu Endereço</a></li>
                                <li><a class="dropdown-item" href="admin"><i class="bi bi-xbox"></i>Admistrador</a></li>
                        </div>
                    </div>

                    <div class="icons_link">
                        <a href=""><i class="bi bi-moon-stars-fill"></i></a>
                        <a href=""><i class="bi bi-universal-access-circle"></i></a>
                        <a href="carrinho.php"><i class="bi bi-cart"></i></a>
                    </div>

                </div>

                <div class="navbar_baixo">
                    <a href="Notebook">Notebook</a>
                    <a href="Smartphones">SmartPhone</a>
                    <a href="Acessorios">Acessórios</a>
                    <a href="Monitor">Monitor</a>
                    <a href="Games">Games</a>
                    <a href="Hardware">Hardware</a>
                </div>

            </nav>
        </div>

    </header>

    <main>
        <?php

        if (isset($_GET["param"])) {
            $param = $_GET["param"];
            $p = explode("/", $param);
        }

        $page = $p[0] ?? "home";
        $produtos = $p[1] ?? NULL;

        if ($page == "paginas") {
            $pagina = "paginas/{$produtos}.phtml";
        } else {
            $pagina = "paginas/{$page}.phtml";
        }

        if (file_exists($pagina)) {
            include $pagina;
        } else {
            include "paginas/erro.phtml";
        }
        

        ?>



    </main>

    <footer>
        <h2 class="text-center">TECNOLO</h2>
        <hr>
        <div class="conteiner_footer">
            <div class="contato">
                <h4>Contato</h4>
                <ul>
                    <li><span><i class="bi bi-whatsapp"></i> (44)999927372</span></li>
                    <li><span><i class="bi bi-envelope"></i> Tecnolo@hotmail.com.br</span></li>
                    <li><span><i class="bi bi-house-door-fill"></i> Campo Mourão PR</span></li>
                    <li><a href="http://lucasmotion.free.nf/?i=1"><i class="bi bi-code-slash"></i>LucasMotion</a></li>
                    <li><a href="https://srvertex.github.io/Site_SrVertex_BETA/"><i class="bi bi-code-slash"></i>SrVertex</a></li>
                </ul>
            </div>

            <div class="login">
                <h4>Usuario</h4>
                <ul>
                    <li><a href="admin" style="width: 130px;">Adminstrador</a></li>
                    <li><a href="login" style="width: 65px;">Login</a></li>
                    <li><a href="cadastro" style="width: 90px;">Cadastro</a></li>
                    <li><a href="esqueciMinhaSenha" style="width: 196px;">Esqueci minha senha</a></li>
                </ul>
            </div>
        </div>
    </footer>



    <ul>
                <?php if ($usuarioLogado): ?>
                    <li>Bem-vindo, <?php echo htmlspecialchars($_SESSION['usuario']['nome']); ?>!</li>
                    <li><a href="logout.php">Sair</a></li>
                <?php else: ?>
                    <li><a href="login.php">Entrar</a></li>
                    <li><a href="cadastro.php">Cadastrar</a></li>
                <?php endif; ?>
            </ul>



</body>

<script src="js/bootstrap.bundle.min.js"></script>
<script src="JS/hello.js"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
    AOS.init();
</script>
<script src="JS/pagamento.js"></script>
<script src="JS//cadastro.js"></script>
<script src="JS//endereco.js"></script>
<script src="JS//admin.jsx"></script>
<script src="JS//redefinirSenha.js"></script>
<script>
    document.getElementById('aviso').addEventListener('click', function() {
        const confirmar = confirm("Você tem certeza que deseja prosseguir?");
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = '';
        const input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'confirmar';
        input.value = confirmar ? 'true' : 'false';
        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    });
</script>

</html>