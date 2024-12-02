<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $cep = preg_replace('/[^0-9]/', '', $_POST['cep']); // Remove caracteres não numéricos

    if (strlen($cep) === 8) {
        $url = "https://viacep.com.br/ws/$cep/json/";

        // Faz a requisição para a API ViaCEP
        $response = file_get_contents($url);

        if ($response) {
            $data = json_decode($response, true);

            if (isset($data['erro'])) {
                echo "<p>CEP não encontrado. Verifique e tente novamente.</p>";
            } else {
                echo "<h2>Informações do CEP</h2>";
                echo "<p><strong>Logradouro:</strong> " . $data['logradouro'] . "</p>";
                echo "<p><strong>Bairro:</strong> " . $data['bairro'] . "</p>";
                echo "<p><strong>Cidade:</strong> " . $data['localidade'] . "</p>";
                echo "<p><strong>Estado:</strong> " . $data['uf'] . "</p>";
            }
        } else {
            echo "<p>Erro ao buscar o CEP. Tente novamente mais tarde.</p>";
        }
    } else {
        echo "<p>CEP inválido. O CEP deve conter 8 dígitos.</p>";
    }
} else {
    echo "<p>Requisição inválida.</p>";
}
?>
