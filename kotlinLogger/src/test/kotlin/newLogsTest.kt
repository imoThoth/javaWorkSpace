import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import org.hamcrest.CoreMatchers.*;
import org.junit.Assert.assertEquals;
import org.junit.Assert.assertThat;
import org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner::class)
class newLogsTest {
    @Mock
    private val mockAppender: Appender<*>? = null

    //Captor is genericised with ch.qos.logback.classic.spi.LoggingEvent
    @Captor
    private val captorLoggingEvent: ArgumentCaptor<LoggingEvent>? = null

    //I've cheated a little here and added the mockAppender to the root logger
    //It's not quite necessary but it also shows you how it can be done
    @Before
    fun setup() {
        val logger: Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME) as Logger
        logger.addAppender(mockAppender)
    }

    //Always have this teardown otherwise we can stuff up our expectations. Besides, it's
    //good coding practise
    @After
    fun teardown() {
        val logger: Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME) as Logger
        logger.detachAppender(mockAppender)
    }

    @Test
    fun shouldConcatAndLog() {
        //given
        val example = ExampleThatLogs()
        //when
        val result = example.concat("foo", "bar")
        //then
        assertEquals("foobar", result)

        //Now verify our logging interactions
        verify(mockAppender).doAppend(captorLoggingEvent!!.capture())
        //Having a genricised captor means we don't need to cast
        val loggingEvent: LoggingEvent = captorLoggingEvent.getValue()
        //Check log level is correct
        assertThat(loggingEvent.getLevel(), `is`(Level.INFO))
        //Check the message being logged is correct
        assertThat(
            loggingEvent.getFormattedMessage(),
            `is`("String a:foo, String b:bar")
        )
    }



}