package br.com.alura.desasafio_android.aplicacao.repository

import br.com.alura.desasafio_android.aplicacao.modelo.mapper.UsuarioMapper
import br.com.alura.desasafio_android.infraestrutura.webservice.PerfilUsuarioService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class PerfilUsuarioRepositoryTest {

    @MockK
    var service = mockk<PerfilUsuarioService>()
    val repositorio by lazy {
        PerfilUsuarioRepository(service)
    }
    @Before
    fun setUp(){
        MockKAnnotations.init(this)
    }
    @Test
    fun `Deve chamar pegaUsuario do service, Quando chamar pegaUsuario do repositorio`(): Unit =
        runBlocking {
            coEvery {
                service.pegaUsuario("")
            } returns mockkClass(UsuarioMapper::class)
            repositorio.pegaUsuario("").first()
            coVerify {
                service.pegaUsuario("")
            }
        }
    @Test
    fun `Deve chamar pegaListaRepositorio do Service, Quando chamar pegaListaRepositorio do Repositorio`(): Unit =
        runBlocking {
        coEvery {
            service.pegaListaRepositorio("")
        } returns mockk()
        repositorio.pegaListaRepositorio("").first()
        coVerify {
            service.pegaListaRepositorio("")
        }
    }

}