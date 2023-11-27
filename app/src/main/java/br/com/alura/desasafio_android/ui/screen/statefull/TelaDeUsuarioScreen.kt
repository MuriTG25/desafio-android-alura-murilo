package br.com.alura.desasafio_android.ui.screen.statefull

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.alura.desasafio_android.ui.screen.stateless.TelaDeUsuarioScreen
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