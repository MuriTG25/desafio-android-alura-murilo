package br.com.alura.desasafio_android.aplicacao.repository

import br.com.alura.desasafio_android.aplicacao.extensoes.mapperParaObjeto
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.dominio.modelo.Usuario
import br.com.alura.desasafio_android.infraestrutura.webservice.PerfilUsuarioService
import br.com.alura.desasafio_android.ui.extensoes.usuarioDeErro
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PerfilUsuarioRepository @Inject constructor(
    private val perfilUsuarioService: PerfilUsuarioService
        ){
    suspend fun pegaUsuario(id:String): Flow<Usuario> {
        return flow {
            emit(
                perfilUsuarioService.pegaUsuario(id)?.mapperParaObjeto() ?: usuarioDeErro
            )
        }.catch { e->
            if(e is UnknownHostException){
                emit(usuarioDeErro)
            }
        }
    }
    suspend fun pegaListaRepositorio(id:String): Flow<List<RepositorioMapper>>{
        return flow {
            emit(
                perfilUsuarioService.pegaListaRepositorio(id)
            )
        }.catch { e->
            if(e is UnknownHostException){
                emit(emptyList())
            }
        }
    }
}