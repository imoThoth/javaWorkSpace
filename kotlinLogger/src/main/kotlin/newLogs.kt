package com.brs

import org.slf4j.LoggerFactory

/**
 * Simple class that we use to trigger a log statement.
 */
class ExampleThatLogs {
    fun concat(a: String, b: String): String {
        LOG.info("String a:$a, String b:$b")
        return a + b
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(ExampleThatLogs::class.java)
    }
}