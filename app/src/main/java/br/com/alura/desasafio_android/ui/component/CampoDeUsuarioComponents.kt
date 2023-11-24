package br.com.alura.desasafio_android.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.desasafio_android.aplicacao.modelo.view.RepositorioView
import br.com.alura.desasafio_android.aplicacao.modelo.view.UsuarioView
import br.com.alura.desasafio_android.ui.extensoes.listaDeRepositoriosDeTeste
import br.com.alura.desasafio_android.ui.extensoes.usuarioDeTeste
import br.com.alura.desasafio_android.ui.extensoes.margemPadrao
import br.com.alura.desasafio_android.ui.extensoes.tamanhoDaCaixa
import br.com.alura.desasafio_android.ui.theme.DesasafioandroidTheme

@Composable
fun CampoDeUsuarioComponents(
    usuario: UsuarioView,
    modifier: Modifier = Modifier,
    listaDeRepositorios: List<RepositorioView> = emptyList(),
    ) {
    Column(
        modifier = modifier.padding(bottom = margemPadrao)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xff2d333b),
                    shape = RoundedCornerShape(
                        bottomEnd = 15.dp,
                        bottomStart = 15.dp,
                    )
                )
        ) {
            ImagemDoUsuarioComponent(
                url = usuario.url,
                modifier = Modifier
                    .offset(y = tamanhoDaCaixa / 2)
                    .align(Alignment.BottomCenter),
            )
        }
        Spacer(modifier = Modifier.height(tamanhoDaCaixa / 2))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(
                top = margemPadrao,
                start = margemPadrao,
                end = margemPadrao,
            )
        ) {
            TextoUsuarioComponent(
                texto = usuario.nome,
                tamanhoDaFonte = 32.sp,
                pesoDaFonte = FontWeight.Bold
            )
            TextoUsuarioComponent(
                texto = usuario.usuario,
                tamanhoDaFonte = 18.sp,
                pesoDaFonte = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(margemPadrao))
            TextoUsuarioComponent(
                texto = usuario.descricao,
                maxlines = Int.MAX_VALUE,
            )
        }
        Spacer(modifier = Modifier.height(margemPadrao/2))
        LazyColumn(
            Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(margemPadrao/2),
        ){
            items(items = listaDeRepositorios){
                RepositorioComponent(repositorio = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CampoDeUsuarioComponentsPreview() {
    DesasafioandroidTheme {
        Surface {
            CampoDeUsuarioComponents(
                usuario = usuarioDeTeste,
                listaDeRepositorios = listaDeRepositoriosDeTeste
            )
        }
    }

}