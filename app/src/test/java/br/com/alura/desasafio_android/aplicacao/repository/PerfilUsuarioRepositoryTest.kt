//package br.com.alura.desasafio_android.aplicacao.repository
//
//import br.com.alura.desasafio_android.infraestrutura.webservice.PerfilUsuarioService
//import io.mockk.MockKAnnotations
//import io.mockk.coEvery
//import io.mockk.coVerify
//import io.mockk.impl.annotations.InjectMockKs
//import io.mockk.mockk
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//
//class PerfilUsuarioRepositoryTest {
//
//    @InjectMockKs
//    var service: PerfilUsuarioService
//    val repositorio by lazy {
//        PerfilUsuarioRepository(service)
//    }
//    @Before
//    fun setUp(){
//        MockKAnnotations.init(this)
//    }
//
//
//    @Test
//    fun `Deve chamar pegaUsuario do service, Quando chamar pegaUsuario do repositorio`(): Unit =
//        runBlocking {
//            coEvery {
//                service.pegaUsuario("")
//            } returns mockk()
//            repositorio.pegaUsuario("")
//            coVerify {
//                service.pegaUsuario("")
//            }
//        }
//
//}