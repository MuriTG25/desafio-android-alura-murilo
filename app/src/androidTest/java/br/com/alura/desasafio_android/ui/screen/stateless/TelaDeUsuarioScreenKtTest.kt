package br.com.alura.desasafio_android.ui.screen.stateless

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.alura.desasafio_android.auxiliarDoTeste.botaoRecarregar
import br.com.alura.desasafio_android.auxiliarDoTeste.descricaoAbaRepositorio
import br.com.alura.desasafio_android.auxiliarDoTeste.descricaoImagem
import br.com.alura.desasafio_android.auxiliarDoTeste.descricaoTelaCarregamento
import br.com.alura.desasafio_android.auxiliarDoTeste.descricaoUsuario
import br.com.alura.desasafio_android.auxiliarDoTeste.esperaAteATelaAparecer
import br.com.alura.desasafio_android.auxiliarDoTeste.mensagemFalha
import br.com.alura.desasafio_android.auxiliarDoTeste.nomeUsuario
import br.com.alura.desasafio_android.auxiliarDoTeste.usernameUsuario
import br.com.alura.desasafio_android.auxiliarDoTeste.verificaSeMostraOComponentePelaDescricao
import br.com.alura.desasafio_android.auxiliarDoTeste.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez
import br.com.alura.desasafio_android.auxiliarDoTeste.verificaSeMostraOComponentePeloTexto
import br.com.alura.desasafio_android.auxiliarDoTeste.verificaSeOElementoEClicavel
import br.com.alura.desasafio_android.ui.activity.TelaDeUsuarioActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
class TelaDeUsuarioScreenKtTest{
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val testeDeUI = createAndroidComposeRule(TelaDeUsuarioActivity::class.java)
    private fun esperaATelaAparecerCorreto(){
        testeDeUI.esperaAteATelaAparecer(usernameUsuario)
    }
    private fun esperaATelaAparecerFalha(){
        testeDeUI.esperaAteATelaAparecer(mensagemFalha)
    }
    @Test
    fun deveMostrarNomeEListaDeRepositorios_QuandoAbrirOAplicativo(){
        esperaATelaAparecerCorreto()
        testeDeUI.verificaSeMostraOComponentePelaDescricao(descricaoImagem)
        testeDeUI.verificaSeMostraOComponentePeloTexto(nomeUsuario)
        testeDeUI.verificaSeMostraOComponentePeloTexto(usernameUsuario)
        testeDeUI.verificaSeMostraOComponentePeloTexto(descricaoUsuario)
        testeDeUI.verificaSeMostraOComponentePeloTexto(nomeUsuario)
        testeDeUI.verificaSeMostraOComponentePelaDescricaoMaisDe1Vez(descricaoAbaRepositorio,2)
    }
    @Test
    fun deveMostrarTelaCarregamento_QuandoAbrirAplicativo(){
        testeDeUI.verificaSeMostraOComponentePelaDescricao(descricaoTelaCarregamento)
    }
    @Test
    fun deveMostrarMensagemErroEBotaoREcarregar_QuandoFalharConexao(){
        esperaATelaAparecerFalha()
        testeDeUI.verificaSeMostraOComponentePeloTexto(mensagemFalha)
        testeDeUI.verificaSeMostraOComponentePeloTexto(botaoRecarregar)
        testeDeUI.verificaSeOElementoEClicavel(botaoRecarregar)
    }


}