package br.com.alura.desasafio_android.auxiliarDoTeste

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.UsuarioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.aplicacao.modelo.view.UsuarioView
import br.com.alura.desasafio_android.dominio.modelo.Repositorio
import br.com.alura.desasafio_android.dominio.modelo.Usuario

fun UsuarioMapper.mapperParaObjeto() = Usuario(
    url = this.url,
    nome = this.nome ?: "",
    usuario = this.usuario ?: "",
    descricao = this.descricao
)

val usuarioMapperVazio = UsuarioMapper()
val usuarioMapperMinimo = UsuarioMapper(
    nome = "José",
    usuario = "jose1234",
)
val usuarioMapperCompleto = UsuarioMapper(
    url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMaeUY22IRHZorIm7FSRUEg3KwvyOwGJ3Uep_EhMYOM2UgFpFAgbJ3xG7A87fgxc1Q-L8&usqp=CAU",
    nome = "José",
    usuario = "jose1234",
    descricao = LoremIpsum(30).values.first()
)
val usuarioMinimo = Usuario(
    nome = "José",
    usuario = "jose1234",
)
val usuarioCompleto = Usuario(
    url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMaeUY22IRHZorIm7FSRUEg3KwvyOwGJ3Uep_EhMYOM2UgFpFAgbJ3xG7A87fgxc1Q-L8&usqp=CAU",
    nome = "José",
    usuario = "jose1234",
    descricao = LoremIpsum(30).values.first()
)
val urlTeste =
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMaeUY22IRHZorIm7FSRUEg3KwvyOwGJ3Uep_EhMYOM2UgFpFAgbJ3xG7A87fgxc1Q-L8&usqp=CAU"
val nomeTeste = "José"
val usuarioTeste = "jose1234"
val descricaoTeste = LoremIpsum(30).values.first()

val listaDeRepositoriosMapperParaTestes = listOf<RepositorioMapper>(
    RepositorioMapper("projeto 1", LoremIpsum(10).values.first()),
    RepositorioMapper("projeto 2"),
    RepositorioMapper(),
)
val repositorioMapperParaTestes =
    RepositorioMapper("projeto 1", LoremIpsum(10).values.first())

val listaDeRepositoriosParaTestes = listOf<Repositorio>(
    Repositorio("projeto 1", LoremIpsum(10).values.first()),
    Repositorio("projeto 2")
)
val repositorioParaTestes =
    Repositorio("projeto 1", LoremIpsum(10).values.first())

val repositorioNome1 = "projeto 1"
val repositorioNome2 = "projeto 2"
val repositorioDescricao = LoremIpsum(10).values.first()