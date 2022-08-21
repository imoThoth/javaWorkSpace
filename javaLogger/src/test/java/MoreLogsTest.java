import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoggerFactory.class})
public class MoreLogsTest {
    private static Logger mockLOG;

    @BeforeClass
    public static void setup(){
        mockStatic(LoggerFactory.class);
        mockLOG = mock(Logger.class);
        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(mockLOG);
    }

    @Test
    public void testIt(){
        MoreLogs additionalLogs = new MoreLogs();
        additionalLogs.doStuff(20);

        verify(mockLOG, times(1)).info(anyString());
    }

    @Test
    public void testIt2(){
        MoreLogs additionalLogs = new MoreLogs();
        additionalLogs.doStuff(2);

        verify(mockLOG, times(1)).info("OOOohhh...A number less than 5");
    }

    @AfterClass
    public static void verifyStatic() {
        //two test with same expectations
        verify(mockLOG, times(1)).info("true");
        verify(mockLOG, times(1)).info("false");
        verify(mockLOG, times(2)).info(anyString());
    }
}
