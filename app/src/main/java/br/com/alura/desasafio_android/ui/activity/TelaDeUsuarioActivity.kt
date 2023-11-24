package br.com.alura.desasafio_android.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import br.com.alura.desasafio_android.ui.screen.statefull.TelaDeUsuarioScreen
import br.com.alura.desasafio_android.ui.theme.DesasafioandroidTheme
import br.com.alura.desasafio_android.ui.viewmodel.TelaDeUsuarioViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TelaDeUsuarioActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            telaCompose()
    }
    private fun telaCompose() {
        val viewModel by viewModels<TelaDeUsuarioViewModel>()
        setContent {
            DesasafioandroidTheme {
                Surface {
                    TelaDeUsuarioScreen(viewModel)
                }
            }
        }
    }
}