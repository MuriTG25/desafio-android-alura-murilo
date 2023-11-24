package br.com.alura.desasafio_android.aplicacao.repository

import br.com.alura.desasafio_android.aplicacao.extensoes.mapperParaObjeto
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.dominio.modelo.Usuario
import br.com.alura.desasafio_android.infraestrutura.webservice.PerfilUsuarioService
import br.com.alura.desasafio_android.ui.extensoes.usuarioDeErro
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PerfilUsuarioRepository @Inject constructor(
    private val perfilUsuarioService: PerfilUsuarioService
        ){
    suspend fun pegaUsuario(id:String): Flow<Usuario> {
        val usuario =  try {
           perfilUsuarioService.pegaUsuario(id)?.mapperParaObjeto() ?: usuarioDeErro
        } catch (e: UnknownHostException) {
           usuarioDeErro
        }
        return flow {
            emit(usuario)
        }
    }
    suspend fun pegaListaRepositorio(id:String): Flow<List<RepositorioMapper>>{
        val lista =  try {
            perfilUsuarioService.pegaListaRepositorio(id)
        } catch (e: UnknownHostException) {
            emptyList()
        }
        return flow {
            emit(lista)
        }
    }
}