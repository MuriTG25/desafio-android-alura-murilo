package br.com.alura.desasafio_android.aplicacao.repository

import br.com.alura.desasafio_android.aplicacao.modelo.mapper.UsuarioMapper
import br.com.alura.desasafio_android.infraestrutura.webservice.PerfilUsuarioService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Rule
import org.junit.Test

class PerfilUsuarioRepositoryTest {
    @MockK
    private lateinit var service: PerfilUsuarioService
    @InjectMockKs
    lateinit var repositorio: PerfilUsuarioRepository

    @get:Rule
    val mockkRule = MockKRule(this)
    @Test
    fun `Deve chamar pegaUsuario do service, Quando chamar pegaUsuario do repositorio`(): Unit =
        runBlocking {
            coEvery {
                service.pegaUsuario("")
            } returns mockkClass(UsuarioMapper::class)
            repositorio.pegaUsuario("").firstOrNull()
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