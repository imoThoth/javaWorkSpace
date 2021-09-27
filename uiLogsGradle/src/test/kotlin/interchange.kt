import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.powermock.core.classloader.annotations.PrepareForTest


class interchange {

    @RunWith(PowerMockRunner::class)
    @PrepareForTest(Controller::class, LoggerFactory::class)
    class ControllerTest {
        @Test
        @Throws(Exception::class)
        fun name() {
            mockStatic(LoggerFactory::class.java)
            val logger: Logger = mock(Logger::class.java)
            `when`(LoggerFactory.getLogger(any(Class::class.java))).thenReturn(logger)
            Controller().log()
            verify(logger).warn(anyString())
        }
    }

}