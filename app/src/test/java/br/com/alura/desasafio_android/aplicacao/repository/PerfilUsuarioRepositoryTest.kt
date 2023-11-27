package br.com.alura.desasafio_android.aplicacao.repository

import br.com.alura.desasafio_android.infraestrutura.webservice.PerfilUsuarioService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

//TODO vou ter que implementar o hilt test para fazer o teste de mock
class PerfilUsuarioRepositoryTest {
    private val service = spyk<PerfilUsuarioService>()
    private val repositorio by lazy {
        PerfilUsuarioRepository(service)
    }

    @Test
    fun `Deve chamar pegaUsuario do service, Quando chamar pegaUsuario do repositorio`(): Unit =
        runBlocking {
            coEvery {
                service.pegaUsuario("")
            } returns mockk()
            repositorio.pegaUsuario("")
            coVerify {
                service.pegaUsuario("")
            }
        }

}