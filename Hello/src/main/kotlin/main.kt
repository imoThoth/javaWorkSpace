fun main(args: Array<String>) {
    println("Hello World!")
    println("Enter your name? ")
    val name = readLine()
    println("Hello $name") //$dollar sign is used to refer to a variable

    var i = 10
    var s = "$i"

    println(s)

}