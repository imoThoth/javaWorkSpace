import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Controller {
    var logger: Logger = LoggerFactory.getLogger(ModuleLayer.Controller::class.java)

    fun log() { logger.warn("yup") }
}