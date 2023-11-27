package br.com.alura.desasafio_android.aplicacao.extensoes

import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.aplicacao.modelo.view.UsuarioView
import br.com.alura.desasafio_android.auxiliarDoTeste.descricaoTeste
import br.com.alura.desasafio_android.auxiliarDoTeste.listaDeRepositoriosMapperParaTestes
import br.com.alura.desasafio_android.auxiliarDoTeste.listaDeRepositoriosParaTestes
import br.com.alura.desasafio_android.auxiliarDoTeste.nomeTeste
import br.com.alura.desasafio_android.auxiliarDoTeste.repositorioDescricao
import br.com.alura.desasafio_android.auxiliarDoTeste.repositorioMapperParaTestes
import br.com.alura.desasafio_android.auxiliarDoTeste.repositorioNome1
import br.com.alura.desasafio_android.auxiliarDoTeste.repositorioNome2
import br.com.alura.desasafio_android.auxiliarDoTeste.repositorioParaTestes
import br.com.alura.desasafio_android.auxiliarDoTeste.urlTeste
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioCompleto
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMapperCompleto
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMapperMinimo
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMapperVazio
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioMinimo
import br.com.alura.desasafio_android.auxiliarDoTeste.usuarioTeste
import br.com.alura.desasafio_android.dominio.modelo.Repositorio
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
    @Test
    fun `Deve retornar Repositorio, Quando converter um RepositorioMapper`(){
        repositorioMapperParaTestes.shouldBeInstanceOf(RepositorioMapper::class)
        val repositorio = repositorioMapperParaTestes.mapperParaRepositorio()
        repositorio.shouldBeInstanceOf(Repositorio::class)
        repositorio.nome.shouldBeEqualTo(repositorioNome1)
        repositorio.descricao.shouldBeEqualTo(repositorioDescricao)
    }
    @Test
    fun `Deve converter uma lista em Repositorio, Quando passar uma lista de RepositorioMapper`(){
        listaDeRepositoriosMapperParaTestes[0].shouldBeInstanceOf(RepositorioMapper::class)
        listaDeRepositoriosMapperParaTestes[1].shouldBeInstanceOf(RepositorioMapper::class)
        listaDeRepositoriosMapperParaTestes[2].shouldBeInstanceOf(RepositorioMapper::class)
        val listaRepositorio = listaDeRepositoriosMapperParaTestes.map {
            it.mapperParaRepositorio()
        }
        listaRepositorio[0].shouldBeInstanceOf(Repositorio::class)
        listaRepositorio[1].shouldBeInstanceOf(Repositorio::class)
        listaRepositorio[2].shouldBeInstanceOf(Repositorio::class)
    }
    @Test
    fun `Deve deixar a descricao nula, Quando passar uma descricao de RepositorioMapper nula`(){
        listaDeRepositoriosMapperParaTestes[1].nome.shouldBeEqualTo(repositorioNome2)
        listaDeRepositoriosMapperParaTestes[1].descricao.shouldBeNull()
        val listaRepositorio = listaDeRepositoriosMapperParaTestes.map {
            it.mapperParaRepositorio()
        }
        listaRepositorio[1].nome.shouldBeEqualTo(repositorioNome2)
        listaRepositorio[1].descricao.shouldBeNull()
    }
    @Test
    fun `Deve converter nome em String vazia, Quando passar um nome de RepositorioMapper nula`(){
        listaDeRepositoriosMapperParaTestes[2].nome.shouldBeNull()
        listaDeRepositoriosMapperParaTestes[2].descricao.shouldBeNull()
        val listaRepositorio = listaDeRepositoriosMapperParaTestes.map {
            it.mapperParaRepositorio()
        }
        listaRepositorio[2].nome.shouldBeEqualTo("")
        listaRepositorio[2].descricao.shouldBeNull()
    }
    @Test
    fun `Deve retornar RepositorioView, Quando converter um RepositorioMapper`(){
        repositorioMapperParaTestes.shouldBeInstanceOf(RepositorioMapper::class)
        val repositorio = repositorioMapperParaTestes.mapperParaView()
        repositorio.shouldBeInstanceOf(RepositorioView::class)
        repositorio.nome.shouldBeEqualTo(repositorioNome1)
        repositorio.descricao.shouldBeEqualTo(repositorioDescricao)
    }
    @Test
    fun `Deve converter uma lista em RepositorioView, Quando passar uma lista de RepositorioMapper`(){
        listaDeRepositoriosMapperParaTestes[0].shouldBeInstanceOf(RepositorioMapper::class)
        listaDeRepositoriosMapperParaTestes[1].shouldBeInstanceOf(RepositorioMapper::class)
        listaDeRepositoriosMapperParaTestes[2].shouldBeInstanceOf(RepositorioMapper::class)
        val listaRepositorio = listaDeRepositoriosMapperParaTestes.map {
            it.mapperParaView()
        }
        listaRepositorio[0].shouldBeInstanceOf(RepositorioView::class)
        listaRepositorio[1].shouldBeInstanceOf(RepositorioView::class)
        listaRepositorio[2].shouldBeInstanceOf(RepositorioView::class)
    }
    @Test
    fun `Deve converter descricao em String vazia, Quando passar uma descricao de RepositorioMapper nula`(){
        listaDeRepositoriosMapperParaTestes[1].nome.shouldBeEqualTo(repositorioNome2)
        listaDeRepositoriosMapperParaTestes[1].descricao.shouldBeNull()
        val listaRepositorio = listaDeRepositoriosMapperParaTestes.map {
            it.mapperParaView()
        }
        listaRepositorio[1].nome.shouldBeEqualTo(repositorioNome2)
        listaRepositorio[1].descricao.shouldBeEqualTo("")
    }
    @Test
    fun `Deve converter nome e descricao em String vazia, Quando passar um nome e descricao de RepositorioMapper nula`(){
        listaDeRepositoriosMapperParaTestes[2].nome.shouldBeNull()
        listaDeRepositoriosMapperParaTestes[2].descricao.shouldBeNull()
        val listaRepositorio = listaDeRepositoriosMapperParaTestes.map {
            it.mapperParaRepositorio()
        }
        listaRepositorio[2].nome.shouldBeEqualTo("")
        listaRepositorio[2].descricao.shouldBeNull()
    }@Test
    fun `Deve retornar RepositorioView, Quando converter um Repositorio`(){
        repositorioParaTestes.shouldBeInstanceOf(Repositorio::class)
        val repositorio = repositorioParaTestes.repositorioParaView()
        repositorio.shouldBeInstanceOf(RepositorioView::class)
        repositorio.nome.shouldBeEqualTo(repositorioNome1)
        repositorio.descricao.shouldBeEqualTo(repositorioDescricao)
    }
    @Test
    fun `Deve converter uma lista em RepositorioView, Quando passar uma lista de Repositorio`(){
        listaDeRepositoriosParaTestes[0].shouldBeInstanceOf(Repositorio::class)
        listaDeRepositoriosParaTestes[1].shouldBeInstanceOf(Repositorio::class)
        val listaRepositorio = listaDeRepositoriosParaTestes.map {
            it.repositorioParaView()
        }
        listaRepositorio[0].shouldBeInstanceOf(RepositorioView::class)
        listaRepositorio[1].shouldBeInstanceOf(RepositorioView::class)
    }
    @Test
    fun `Deve converter descricao em String vazia, Quando passar uma descricao de Repositorio nula`(){
        listaDeRepositoriosParaTestes[1].nome.shouldBeEqualTo(repositorioNome2)
        listaDeRepositoriosParaTestes[1].descricao.shouldBeNull()
        val listaRepositorio = listaDeRepositoriosParaTestes.map {
            it.repositorioParaView()
        }
        listaRepositorio[1].nome.shouldBeEqualTo(repositorioNome2)
        listaRepositorio[1].descricao.shouldBeEqualTo("")
    }
}