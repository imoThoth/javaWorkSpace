
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC

val logger: Logger = LoggerFactory.getLogger("UI_LOGGER")

fun logStuff(logs: String){
    if(logs.length > 1){
        logger.info("true")
    }else{
        logger.info("false")
    }
}

fun main() {
    logStuff("A New Log")
    println("Logger class:  " + logger.javaClass.toString())
}
