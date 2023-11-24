package br.com.alura.desasafio_android.ui.stateholder

import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.aplicacao.modelo.view.UsuarioView

sealed class TelaDeUsuarioUiState{
    object Carregando: TelaDeUsuarioUiState()
    object Falha: TelaDeUsuarioUiState()
    data class Sucesso(
        val usuario: UsuarioView = UsuarioView("","","",""),
        val listaRepositorios: List<RepositorioView> = emptyList(),
    ): TelaDeUsuarioUiState()
}
