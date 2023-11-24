package br.com.alura.desasafio_android.ui.component


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import br.com.alura.desasafio_android.ui.theme.montserratFont

@Composable
fun TextoUsuarioComponent(
    modifier: Modifier = Modifier,
    texto: String,
    maxlines: Int = 1,
    tamanhoDaFonte: TextUnit = 14.sp,
    pesoDaFonte: FontWeight = FontWeight.Normal,
    corDaFonte: Color = Color.Black
) {
    Text(
        text = texto,
        fontSize = tamanhoDaFonte,
        fontWeight = pesoDaFonte,
        maxLines = maxlines,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontFamily = montserratFont,
        color = corDaFonte
    )
}

@Preview
@Composable
private fun TextoUsuarioComponentPreview() {
    TextoUsuarioComponent(texto = "ola")
}