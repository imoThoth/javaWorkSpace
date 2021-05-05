//simple function, takes parameter of type string
//returns unit (i.e no return value)
fun printMessage(message:String): Unit{
    println(message)
}

//A function that takes second optional parameter with default val info
//return type is omitted meaning it is a unit
fun printMessageWithPrefix(message: String, prefix: String = "Info"){
    println("[$prefix]$message")
}

//a function that return an integer
fun sum(x: Int, y: Int): Int{
    return x + y
}

//a single-expression function that returns an integer
//inferred
fun multiply(x: Int, y:Int) = x * y

fun main(args: Array<String>) {
    printMessage("Hello")
    printMessageWithPrefix("Whats the status?","Warning")
    println(sum(30, 67))
    println("Inferred: " + multiply(30,67))

}