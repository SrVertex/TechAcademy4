






<section id="main_produtos">

    <div class="top">
        <h2>Hardware</h2>
        <button class="btn-of" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling"><i class="bi bi-list"></i>Filtro</button>

        <div class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
            <div class="header">
                <h5 class="offcanvas-title" id="offcanvasScrollingLabel">FILTRO</h5>
                <button type="button" class="close" data-bs-dismiss="offcanvas" aria-label="Close"><i class="bi bi-x"></i></button>

            </div>
            <hr>
            <div class="offcanvas-body">
                <form action="">
                    <h5>Valor</h5>
                    <ul>
                        <li><input type="checkbox" id="valor1"> <label for="valor1">R$ 500,00</label></li>
                        <li><input type="checkbox" id="valor2"> <label for="valor2">R$ 1000,00</label></li>
                        <li><input type="checkbox" id="valor3"> <label for="valor3">R$ 1200,00</label></li>
                        <li><input type="checkbox" id="valor4"> <label for="valor4">R$ 1500,00</label></li>
                        <li><input type="checkbox" id="valor5"> <label for="valor5">R$ 2000,00</label></li>
                        <li><input type="checkbox" id="valor6"> <label for="valor6">R$ 2400,00</label></li>
                    </ul>
                    <button class="filtrar">Filtrar Agora</button>
                </form>
            </div>
        </div>

    </div>


    <div class="produto_flex">




    <?php
$api = file_get_contents("http://localhost:8080/api/item");
$produtosInfo = json_decode($api);

foreach ($produtosInfo as $produto) {


    $parcela = $produto->preco / 10; 


    // Verifica se o produto tem categoria e se a categoria é "Acao"
    if (isset($produto->categoria) && $produto->categoria->nome == 'Acao') {
        // Exibe o conteúdo apenas se a categoria for "Acao"
        echo '<a href="detalheProduto/' . $produto->id_item . '" class="conteiner_produto">';
        echo '<div class="imagem">';
        // Verifica se a foto está disponível ou usa uma imagem padrão
        $foto = isset($produto->foto) && !empty($produto->foto) ? $produto->foto : 'imagens/default.png';
        echo '<img src="' . $foto . '" alt="Imagem do produto">';
        echo '</div>';
        echo '<div class="descricao">';
        // Exibe o nome do produto
        echo '<p class="desc">' . htmlspecialchars($produto->nome) . '</p>';
        // Verifica se o preço está disponível
        $preco = isset($produto->preco) && $produto->preco !== null ? number_format($produto->preco, 2, ',', '.') : 'Preço indisponível';
        echo '<p class="preco">R$ ' . $preco . '</p>';
        // Exibe uma mensagem de preço parcelado (ajustado para um exemplo fixo ou um valor real do produto)
        echo '<p class="sub_preco">À vista no Pix ou até <span>10x de R$' . number_format($parcela, 2, ',', '.') . 'sem juros</span></p>';
        echo '</div>';
        echo '</a>';
    }
}
?>


    </div>
</section