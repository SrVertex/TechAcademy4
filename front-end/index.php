<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TECNOLO</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">
    <base href="http://localhost/techAcademy4/front-end/index.php">

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">


</head>

<header>

    <div class="nav_mobile">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">

                <div class="logo">

                    <!-- <a href=""><img src="imagens//logo///logo.png" alt></a> -->
                    <a class="navbar-brand nome_logo" href="#">TECNOLO</a>

                </div>

                <div class="area_botao">
                    <a href=""><i class="bi bi-moon-stars-fill"></i></a>
                    <a href=""><i class="bi bi-universal-access-circle"></i></a>
                    <a href=""><i class="bi bi-cart"></i></a>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>

            </div>

            <form class="d-flex" role="search">
                <input class="2" type="search" placeholder="Digite o que você procura..." aria-label="Search">
                <a href="" type="submit"> <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
                        <path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1" />
                    </svg></a>
            </form>


            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto mb-2 mb-lg-0"> <!-- mx-auto centraliza horizontalmente -->
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Categorias
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Notebook</a></li>
                            <li><a class="dropdown-item" href="#">Smartphone</a></li>
                            <li><a class="dropdown-item" href="#">Hardware</a></li>
                        </ul>
                    </li>

                </ul>
            </div>


        </nav>
    </div>

    <div class="nav_desk">

    </div>

</header>

<body>

    <main>
        <?php
        if (isset($_GET["param"])) {
            $param = $_GET["param"];
            $p = explode("/", $param);
        }

        $page = $p[0] ?? "home";

        if ($page == "home") {
            $pagina = "paginas/{$page}.php";
        }

        if (file_exists($pagina)) {
            include $pagina;
        } else {
            include "paginas/erro.php";
        }
        ?>
    </main>

    <footer>

    </footer>

</body>


<script src="js/bootstrap.bundle.min.js"></script>


</html>