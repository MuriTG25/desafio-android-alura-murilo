package br.com.alura.desasafio_android.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.ui.extensoes.repositorioParaVisualizacao

@Composable
fun RepositorioComponent(
    repositorio: RepositorioView,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            TextoUsuarioComponent(
                texto = repositorio.nome,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2d333b)),
                tamanhoDaFonte = 24.sp,
                corDaFonte = Color.White
            )
            if (!repositorio.descricao.isNullOrBlank()) {
                TextoUsuarioComponent(
                    texto = repositorio.descricao,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    maxlines = 6,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RepositorioComponentPreview() {
    RepositorioComponent(repositorio = repositorioParaVisualizacao)
}