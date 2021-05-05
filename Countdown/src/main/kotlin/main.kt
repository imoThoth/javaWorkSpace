//object Main {
   // @JvmStatic
    fun main(args: Array<String>) {
        val countdown = Countdown()
        val t1 = CountdownThread(countdown)
        t1.name = "Thread 1"
        val t2 = CountdownThread(countdown)
        t2.name = "Thread 2"
        t1.start()
        t2.start()
    }
//}

internal class Countdown {
    private var i = 0

    //synchronized keyword, tells jvm
    //run the method with a single thread
    //before letting another thread join the party
    //public synchronized void doCountdown(){
    fun doCountdown() {
        val color: String
        color = when (Thread.currentThread().name) {
            "Thread 1" -> ThreadColour.ANSI_CYAN
            "Thread 2" -> ThreadColour.ANSI_PURPLE
            else -> ThreadColour.ANSI_GREEN
        }
        //uses this.countdown to synchronize methods
        synchronized(this) {
            i = 10
            while (i > 0) {
                println(color + Thread.currentThread().name + ": i=" + i)
                i--
            }
        }
    }
} //Allows us to start the thread

//When instance of class started, calls doCountdown method
internal class CountdownThread(private val threadCountdown: Countdown) : Thread() {
    override fun run() {
        threadCountdown.doCountdown()
    }
}