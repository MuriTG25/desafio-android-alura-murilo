package br.com.alura.desasafio_android.ui.extensoes

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.aplicacao.modelo.view.UsuarioView
import br.com.alura.desasafio_android.dominio.modelo.Usuario

val usuarioDeTeste= UsuarioView(
    url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMaeUY22IRHZorIm7FSRUEg3KwvyOwGJ3Uep_EhMYOM2UgFpFAgbJ3xG7A87fgxc1Q-L8&usqp=CAU",
    nome = "José",
    usuario = "jose1234",
    descricao = LoremIpsum(30).values.first()
)
val usuarioDeErro = Usuario(
    nome = "Erro de conexao",
    usuario = "Ocorreu um erro de conexão com o site",
)

val listaDeRepositoriosDeTeste = listOf<RepositorioView>(
    RepositorioView("projeto 1",LoremIpsum(10).values.first()),
    RepositorioView("projeto 2",LoremIpsum(30).values.first()),
    RepositorioView("projeto 1",""),
)
val listaDeRepositoriosDeErro = listOf<RepositorioMapper>(
    RepositorioMapper("erro ao encontrar o repositório",""),
)
val repositorioDeTeste =
    RepositorioView("projeto 1",LoremIpsum(10).values.first())
