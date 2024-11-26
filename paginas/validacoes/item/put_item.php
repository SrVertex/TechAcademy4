<?php
if ($_SERVER['REQUEST_METHOD'] === 'PUT') {
    // Lê os dados JSON enviados pelo cliente
    $json = file_get_contents('php://input');
    $dadosProduto = json_decode($json, true);

    if ($dadosProduto) {
        // Processa os dados do produto (igual ao que você fez com POST)
        $idProduto = $dadosProduto['id_item_put']; // ID do produto a ser atualizado
        $nome = $dadosProduto['nome_put'];
        $descricao = $dadosProduto['descricao_put'];
        $preco = (float)$dadosProduto['preco_put'];
        $estoque = (int)$dadosProduto['estoque_put'];
        $atributo_1 = $dadosProduto['atributo_1_put'];
        $atributo_2 = $dadosProduto['atributo_2_put'];
        $atributo_3 = $dadosProduto['atributo_3_put'];
        $atributo_4 = $dadosProduto['atributo_4_put'];
        $atributo_5 = $dadosProduto['atributo_5_put'];
        $atributo_6 = $dadosProduto['atributo_6_put'];
        $categoria_id = (int)$dadosProduto['id_categoria_put'];
        $foto = $dadosProduto['foto_put'];

        // Aqui você poderia realizar o processo de atualização no banco de dados, por exemplo:
        // Atualizar no banco de dados usando SQL ou ORM (Dependerá da lógica que você já possui)

        echo json_encode(['success' => true, 'message' => 'Produto atualizado com sucesso.']);
    } else {
        echo json_encode(['success' => false, 'message' => 'Erro ao processar os dados.']);
    }
} else {
    echo json_encode(['success' => false, 'message' => 'Método HTTP inválido.']);
}
