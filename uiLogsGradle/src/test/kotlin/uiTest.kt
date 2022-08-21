
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.MockedStatic.Verification
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.powermock.core.classloader.annotations.PrepareForTest
import org.slf4j.Logger
import org.slf4j.LoggerFactory

//class Test {
//
//
//    @RunWith(MockitoJUnitRunner::class)
//    @PrepareForTest(LoggerFactory::class)
//    class ControllerTest {
//        @Test
//        @Throws(Exception::class)
//        fun name() {
//            mockStatic(LoggerFactory::class.java)
//            val logger: Logger = mock(Logger::class.java)
//            `when`(LoggerFactory.getLogger(any(Class::class.java))).thenReturn(logger)
//            logStuff("Say What")
//            verify(logger).warn(anyString())
//        }
//    }

//    @Test
//    fun name() {
//        try {
//            mockStatic(LoggerFactory::class.java).use { integerMock ->
//                val logger: Logger = mock(Logger::class.java)
//                integerMock.`when`<Any> { LoggerFactory.getLogger(any(Class::class.java)) }
//                    .thenReturn(logger)
//                logStuff("new logs")
//                verify(logger).info(any())
//            }
//        }catch(IOException e){
//
//        }
//    }
//}