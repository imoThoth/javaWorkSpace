import org.slf4j.LoggerFactory

class MoreLogs {
    private val LOG = LoggerFactory.getLogger(MoreLogs::class.java)

    fun doStuff(a: Boolean) {
        if (a) {
            LOG.info("Hmmm... A true word")
        } else {
            LOG.info("OOOohhh...how false")
        }
    }
}