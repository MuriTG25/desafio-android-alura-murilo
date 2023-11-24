package br.com.alura.desasafio_android.aplicacao.extensoes

import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.UsuarioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.view.UsuarioView
import br.com.alura.desasafio_android.dominio.modelo.Repositorio
import br.com.alura.desasafio_android.dominio.modelo.Usuario

fun UsuarioMapper.mapperParaObjeto() = Usuario(
        url = this.url,
        nome = this.nome ?: "",
        usuario = this.usuario ?: "",
        descricao = this.descricao
    )

fun Usuario.usuarioParaView() = UsuarioView(
    url = this.url ?: "",
    nome = this.nome,
    usuario = this.usuario,
    descricao = this.descricao ?: ""
)

fun RepositorioMapper.mapperParaRepositorio() = Repositorio(
    nome = this.nome ?: "",
    descricao = this.descricao ?: "",
)
fun RepositorioMapper.mapperParaView() = RepositorioView(
    nome = this.nome ?: "",
    descricao = this.descricao?: "",
)

fun Repositorio.repositorioParaView() = RepositorioView(
    nome = this.nome,
    descricao = this.descricao ?: "",
)



