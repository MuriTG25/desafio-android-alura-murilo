package br.com.alura.desasafio_android.ui.screen.stateless

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.desasafio_android.ui.component.CampoDeUsuarioComponents
import br.com.alura.desasafio_android.ui.component.TelaDeCarregamentoComponent
import br.com.alura.desasafio_android.ui.component.TelaDeFalhaComponent
import br.com.alura.desasafio_android.ui.extensoes.listaDeRepositoriosParaVisualizacao
import br.com.alura.desasafio_android.ui.extensoes.repositorioParaVisualizacao
import br.com.alura.desasafio_android.ui.extensoes.usuarioParaVisualizacao
import br.com.alura.desasafio_android.ui.stateholder.TelaDeUsuarioUiState
import br.com.alura.desasafio_android.ui.theme.DesasafioandroidTheme

@Composable
fun TelaDeUsuarioScreen(
    state: TelaDeUsuarioUiState,
    aoTentarBuscarNovamenteOUsuario: () -> Unit = {},
) {
    when (state) {
        is TelaDeUsuarioUiState.Carregando ->
            TelaDeCarregamentoComponent()
        is TelaDeUsuarioUiState.Falha ->
            TelaDeFalhaComponent(
                aoTentarBuscarNovamenteOUsuario = aoTentarBuscarNovamenteOUsuario
            )
        is TelaDeUsuarioUiState.Sucesso ->
            CampoDeUsuarioComponents(
                usuario = state.usuario,
                listaDeRepositorios = state.listaRepositorios
            )
    }

}

@Preview(showSystemUi = true)
@Composable
private fun TelaDeUsuarioScreenSucessoPreview() {
    DesasafioandroidTheme {
        Surface {
            TelaDeUsuarioScreen(
                state = TelaDeUsuarioUiState.Sucesso(
                    usuario = usuarioParaVisualizacao,
                    listaRepositorios = listaDeRepositoriosParaVisualizacao
                )
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun TelaDeUsuarioScreenCarregandoPreview() {
    DesasafioandroidTheme {
        Surface {
            TelaDeUsuarioScreen(
                state = TelaDeUsuarioUiState.Carregando
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun TelaDeUsuarioScreenFalhaPreview() {
    DesasafioandroidTheme {
        Surface {
            TelaDeUsuarioScreen(
                state = TelaDeUsuarioUiState.Falha
            )
        }
    }
}