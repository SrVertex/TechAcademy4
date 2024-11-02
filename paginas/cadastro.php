<section id="area_login">
    <div class="conteiner_login">

        <h2>CRIE SUA CONTAR TECNOLO</h2>

        <form action="login" method="post" class="form">

            <input type="email" placeholder="E-mail" style="margin-bottom: 20px;" required>
            <input type="password" placeholder="Senha" style="margin-bottom: 20px;" required>
            <input type="password" placeholder="Confirmar Senha" style="margin-bottom: 20px;" required>
            <input type="nome" placeholder="Nome Completo" style="margin-bottom: 20px;" required>

            <p>Data de Nascimento</p>


            <div class="conteiner_data">

                <input type="date" id="nascimento" style="width: 60%;" required>

            </div>

            <div class="btn_login">
                <a id="link" href="index.php">Voltar</a>
                <button type="submit" id="link">Confirmar</button>
            </div>
        </form>

        <a href="login">Entrar em uma conta Existente</a>
    </div>

    <div class="login_2" style="margin-bottom: 16px;">
        <a href=""><i class="bi bi-google"></i>Google</a>
        <a href=""><i class="bi bi-facebook"></i>Facebook</a>
    </div>

    <div class="check">

        <label for="termos"> <input type="checkbox" id="termos" name="termos">    Quero receber ofertas e novidades por e-mail, SMS, WhatsApp.</label>
        <label for="termos"> <input type="checkbox" id="termos" name="termos">    Li e estou de acordo com as <a href="">políticas da empresa e políticas de privacidade.</a></label>

    </div>

</section>