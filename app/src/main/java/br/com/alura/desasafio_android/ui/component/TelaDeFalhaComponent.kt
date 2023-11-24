package br.com.alura.desasafio_android.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TelaDeFalhaComponent(
    aoTentarBuscarNovamenteOUsuario: () -> Unit = {},
) {
    Column(
        Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Falha ao buscar o usuário")
        Button(onClick = aoTentarBuscarNovamenteOUsuario) {
            Text(text = "Tentar Buscar Novamente")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaDeFalhaComponentPreview() {
    TelaDeCarregamentoComponent()
}