package br.com.alura.desasafio_android.aplicacao.extensoes

import br.com.alura.desasafio_android.aplicacao.modelo.view.UsuarioView
import br.com.alura.desasafio_android.auxiliarDoTeste.descricaoTeste
import br.com.alura.desasafio_android.auxiliarDoTeste.nomeTeste
import br.com.alura.desasafio_android.auxiliarDoTeste.urlTeste
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioCompleto
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMapperCompleto
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMapperMinimo
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMapperVazio
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMinimo
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioTeste
import br.com.alura.desasafio_android.dominio.modelo.Usuario
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test

class ConversorDeMapperEViewKtTest {
    @Test
    fun `Deve retornar Usuario vazio, Quando converter UsuarioMapper Vazio`() {
        usuarioMapperVazio.nome.shouldBeNull()
        usuarioMapperVazio.usuario.shouldBeNull()
        val usuario = usuarioMapperVazio.mapperParaObjeto()
        usuario.nome.shouldBeEqualTo("")
        usuario.usuario.shouldBeEqualTo("")
        usuario.descricao.shouldBeNull()
        usuario.url.shouldBeNull()
        usuario.shouldBeInstanceOf(Usuario::class)
    }
    @Test
    fun `Deve retornar Usuario com Nome E usuario, Quando converter UsuarioMapper com nome e Usuario`() {
        val usuario = usuarioMapperMinimo.mapperParaObjeto()
        usuario.nome.shouldBeEqualTo(nomeTeste)
        usuario.usuario.shouldBeEqualTo(usuarioTeste)
        usuario.descricao.shouldBeNull()
        usuario.url.shouldBeNull()
        usuario.shouldBeInstanceOf(Usuario::class)
    }
    @Test
    fun `Deve retornar Usuario completo, Quando converter UsuarioMapper completo`() {
        val usuario = usuarioMapperCompleto.mapperParaObjeto()
        usuario.nome.shouldBeEqualTo(nomeTeste)
        usuario.usuario.shouldBeEqualTo(usuarioTeste)
        usuario.descricao.shouldBeEqualTo(descricaoTeste)
        usuario.url.shouldBeEqualTo(urlTeste)
        usuario.shouldBeInstanceOf(Usuario::class)
    }
    @Test
    fun `Deve retornar UsuarioView com Nome E usuario, Quando converter Usuario com nome e Usuario`() {
        usuarioMinimo.descricao.shouldBeNull()
        usuarioMinimo.url.shouldBeNull()
        val usuario = usuarioMinimo.usuarioParaView()
        usuario.nome.shouldBeEqualTo(nomeTeste)
        usuario.usuario.shouldBeEqualTo(usuarioTeste)
        usuario.descricao.shouldBeEqualTo("")
        usuario.url.shouldBeEqualTo("")
        usuario.shouldBeInstanceOf(UsuarioView::class)
    }
    @Test
    fun `Deve retornar UsuarioView completo, Quando converter Usuario completo`() {
        val usuario = usuarioCompleto.usuarioParaView()
        usuario.nome.shouldBeEqualTo(nomeTeste)
        usuario.usuario.shouldBeEqualTo(usuarioTeste)
        usuario.descricao.shouldBeEqualTo(descricaoTeste)
        usuario.url.shouldBeEqualTo(urlTeste)
        usuario.shouldBeInstanceOf(UsuarioView::class)
    }
}