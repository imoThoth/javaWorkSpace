import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RunWith(PowerMockRunner::class)
@PrepareForTest(Controller::class, LoggerFactory::class)
class ControllerTest {
    @Test
    @Throws(Exception::class)
    fun name() {
        Mockito.mockStatic(LoggerFactory::class.java)
        val logger = Mockito.mock(Logger::class.java)
        Mockito.`when`(LoggerFactory.getLogger(ArgumentMatchers.any(Class::class.java))).thenReturn(logger)
        Controller().log()
        Mockito.verify(logger).warn(ArgumentMatchers.anyString())
    }
}