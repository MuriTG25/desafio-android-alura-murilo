package br.com.alura.desasafio_android.ui.screen.statefull

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import br.com.alura.desasafio_android.aplicacao.extensoes.mapperParaView
import br.com.alura.desasafio_android.aplicacao.extensoes.usuarioParaView
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.aplicacao.repository.PerfilUsuarioRepository
import br.com.alura.desasafio_android.ui.extensoes.listaDeRepositoriosDeErro
import br.com.alura.desasafio_android.ui.extensoes.usuarioDeErro
import br.com.alura.desasafio_android.ui.screen.stateless.TelaDeUsuarioScreen
import br.com.alura.desasafio_android.ui.stateholder.TelaDeUsuarioUiState
import br.com.alura.desasafio_android.ui.viewmodel.TelaDeUsuarioViewModel

@Composable
fun TelaDeUsuarioScreen(
    viewModel: TelaDeUsuarioViewModel,
) {
    val state by viewModel.uiState.collectAsState()
    TelaDeUsuarioScreen(
        state = state,
        aoTentarBuscarNovamenteOUsuario = {
            viewModel.carregaUsuario()
        }
    )
}