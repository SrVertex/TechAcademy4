






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

























<div id="produtos-container" class="produto_flex">
        <!-- Produtos serão carregados aqui via PHP -->
        <?php
        $api = file_get_contents("http://localhost:8080/api/item");
        $produtosInfo = json_decode($api);

        foreach ($produtosInfo as $produto) {
            $parcela = $produto->preco / 10;
            // Exibindo o produto
            echo '<a href="detalheProduto/' . $produto->id_item . '" class="conteiner_produto" data-preco="' . $produto->preco . '">';
            echo '<div class="imagem">';
            $foto = isset($produto->foto) && !empty($produto->foto) ? $produto->foto : 'imagens/default.png';
            echo '<img src="' . $foto . '" alt="Imagem do produto">';
            echo '</div>';
            echo '<div class="descricao">';
            echo '<p class="desc">' . htmlspecialchars($produto->nome) . '</p>';
            $preco = isset($produto->preco) && $produto->preco !== null ? number_format($produto->preco, 2, ',', '.') : 'Preço indisponível';
            echo '<p class="preco">R$ ' . $preco . '</p>';
            echo '<p class="sub_preco">À vista no Pix ou até <span>10x de R$' . number_format($parcela, 2, ',', '.') . 'sem juros</span></p>';
            echo '</div>';
            echo '</a>';
        }
        ?>
    </div>




















































































    <?php
if ($_SERVER['REQUEST_METHOD'] === 'PUT') {
    // Lê os dados JSON enviados pelo cliente
    $json = file_get_contents('php://input');
    $dadosProduto = json_decode($json, true);

    if ($dadosProduto) {
        // ID do produto que será atualizado
        $idProduto = $dadosProduto['id_item_put'];

        // URL da API que vai receber o PUT
        $url = "http://localhost:8080/api/item/{$idProduto}";

        // Inicia o cURL
        $ch = curl_init($url);

        // Dados que serão enviados no corpo da requisição PUT
        $postData = json_encode([
            'nome' => $dadosProduto['nome_put'],
            'descricao' => $dadosProduto['descricao_put'],
            'preco' => (float)$dadosProduto['preco_put'],
            'estoque' => (int)$dadosProduto['estoque_put'],
            'atributo_1' => $dadosProduto['atributo_1Post'],
            'atributo_2' => $dadosProduto['atributo_2_put'],
            'atributo_3' => $dadosProduto['atributo_3_put'],
            'atributo_4' => $dadosProduto['atributo_4_put'],
            'atributo_5' => $dadosProduto['atributo_5_put'],
            'atributo_6' => $dadosProduto['atributo_6_put'],
            'categoria_id' => (int)$dadosProduto['id_categoria_put'],
            'foto' => $dadosProduto['foto_put']
        ]);

        // Configurações do cURL
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
        curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);
        curl_setopt($ch, CURLOPT_HTTPHEADER, [
            'Content-Type: application/json',
            'Content-Length: ' . strlen($postData)
        ]);

        // Executa a requisição
// Executa a requisição
$response = curl_exec($ch);

// Verifica se houve algum erro na requisição
if(curl_errno($ch)) {
    echo json_encode(['success' => false, 'message' => 'Erro na requisição: ' . curl_error($ch)]);
} else {
    // Verifica o código de status HTTP
    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
    if ($httpCode >= 200 && $httpCode < 300) {
        // Se o código de status for 2xx, é sucesso
        echo json_encode(['success' => true, 'message' => 'Produto atualizado com sucesso!']);
    } else {
        // Se o código de status não for 2xx, é erro
        echo json_encode(['success' => false, 'message' => "Erro: Código HTTP $httpCode"]);
    }
}

// Fecha o cURL
curl_close($ch);

    } else {
        echo json_encode(['success' => false, 'message' => 'Dados inválidos']);
    }
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}

















