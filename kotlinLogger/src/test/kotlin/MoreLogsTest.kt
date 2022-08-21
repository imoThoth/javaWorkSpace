import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RunWith(PowerMockRunner::class)
@PrepareForTest(Controller::class,LoggerFactory::class)
class MoreLogsTest {

    private var mockLOG: Logger = Mockito.mock(Logger::class.java)

    @BeforeClass
    companion object {
    }

    @Test
    @Throws(Exception::class)
    fun testIt() {
        val additionalLogs = MoreLogs()
        additionalLogs.doStuff(true)
        Mockito.verify(mockLOG, Mockito.times(1)).info(ArgumentMatchers.anyString())
    }

}      