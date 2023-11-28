package br.com.alura.desasafio_android.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import br.com.alura.desasafio_android.R
import br.com.alura.desasafio_android.ui.extensoes.tamanhoDaCaixa
import coil.compose.AsyncImage

@Composable
fun ImagemDoUsuarioComponent(
    url: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        modifier = modifier
            .size(tamanhoDaCaixa)
            .clip(CircleShape),
        model = url,
        contentDescription = "imagem do usuario",
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.ic_image_not_found),
        error = painterResource(id = R.drawable.ic_image_not_found),
    )
}

@Preview(showBackground = true)
@Composable
private fun ImagemDoUsuarioComponent() {
    ImagemDoUsuarioComponent(url = "")
}