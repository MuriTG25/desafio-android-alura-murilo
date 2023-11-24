package br.com.alura.desasafio_android.infraestrutura.webservice

import br.com.alura.desasafio_android.aplicacao.modelo.mapper.RepositorioMapper
import br.com.alura.desasafio_android.aplicacao.modelo.mapper.UsuarioMapper
import retrofit2.http.GET
import retrofit2.http.Path

interface PerfilUsuarioService {
    @GET("{id}")
    suspend fun pegaUsuario(@Path("id")id:String): UsuarioMapper?

    @GET("{id}/repos")
    suspend fun pegaListaRepositorio(@Path("id")id:String): List<RepositorioMapper>
}


