package br.com.alura.desasafio_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.desasafio_android.aplicacao.extensoes.mapperParaView
import br.com.alura.desasafio_android.aplicacao.extensoes.usuarioParaView
import br.com.alura.desasafio_android.aplicacao.repository.PerfilUsuarioRepository
import br.com.alura.desasafio_android.ui.extensoes.murilo
import br.com.alura.desasafio_android.ui.extensoes.usuarioDeErro
import br.com.alura.desasafio_android.ui.stateholder.TelaDeUsuarioUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TelaDeUsuarioViewModel @Inject constructor(
    private val repository: PerfilUsuarioRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow<TelaDeUsuarioUiState>(
        TelaDeUsuarioUiState.Carregando
    )
    private var atualUiStateJob: Job? = null
    val uiState = _uiState.asStateFlow()

    init {
        carregaUsuario()
    }

    fun carregaUsuario() {
        atualUiStateJob?.cancel()
        atualUiStateJob = viewModelScope.launch {
            repository.pegaUsuario(murilo).onStart {
                _uiState.update {
                    TelaDeUsuarioUiState.Carregando
                }
            }.collectLatest { usuario ->
                if (usuario == usuarioDeErro) {
                    falhaDeCarregamento()
                } else {
                    val repositoriosEncontrado =
                        repository.pegaListaRepositorio(murilo)
                            .firstOrNull()
                    _uiState.update {
                        TelaDeUsuarioUiState.Sucesso(
                            usuario = usuario.usuarioParaView(),
                            listaRepositorios = repositoriosEncontrado?.map { lista ->
                                lista.mapperParaView()
                            } ?: emptyList()
                        )
                    }
                }
            }
        }
    }

    private fun falhaDeCarregamento() {
        _uiState.update {
            TelaDeUsuarioUiState.Falha
        }
    }
}