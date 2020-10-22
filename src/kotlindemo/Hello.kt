package kotlindemo

import kotlindemo.classdemo.Customer
import kotlindemo.classdemo.InitOrderDemo

fun main() {
    println("Hello World!")
//    var name = readLine()
//    println("Hello $name!")
    printSum1(1, 2)
    rangeLoop2()
    collection1()

    var customer = Customer("Tom","tom@gmail.com")
    var initOrderDemo = InitOrderDemo("Age");
}

/**
 * 带有两个 Int 参数、返回 Int 的函数
 */
fun sum(a: Int, b: Int): Int {
    return a + b;
}

/**
 * 将表达式作为函数体、返回值类型自动推断的函数
 */
fun sum(a: Int, b: Int, c: Int) = a + b + c

/**
 * 函数返回无意义的值
 */
fun printSum1(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

/**
 * Unit 返回类型可以省略
 */
fun printSum2(a: Int, b: Int) {
    println("sum is ${a + b}")
}

/**
 * 定义变量
 */
fun variable() {
    val a = 3
    var b: Int = 3
    val c: Int
    c = 3
    println("sum is ${a + b + c}")
}

fun stringTemplate() {
    var a = 1
    val s1 = "a is $a" // 模板中的简单名称：
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"// 模板中的任意表达式：
}

/**
 * 条件表达式
 */
fun maxOf1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }
    return b
}

/**
 * 在 Kotlin 中，if 也可以用作表达式
 */
fun maxOf2(a: Int, b: Int) = if (a > b) a else b


/**
 * 当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
 * 如果 str 的内容不是数字返回 null：
 */
fun parseInt(str: String): Int? {
    // ……
    return str.toInt();
}

/**
 * 使用返回可空值的函数
 */
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}


/**
 * 型检测与自动类型转换
 * is 运算符检测一个表达式是否某类型的一个实例。
 * 如果一个不可变的局部变量或属性已经判断出为某类型，那么检测后的分支中可以直接当作该类型使用，无需显式转换：
 */
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` 在该条件分支内自动转换成 `String`
        return obj.length
    }

    // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
    return null
}

/**
 * for 循环
 */
fun loop1() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}

/**
 * for 循环
 */
fun loop2() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

/**
 * while 循环
 */
fun whileTest() {
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

/**
 * when 表达式
 */
fun whenTest(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

/**
 * 使用区间（range）
 * 使用 in 运算符来检测某个数字是否在指定区间内
 * !in
 */
fun range() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

/**
 * 区间迭代
 */
fun rangeLoop1() {
    for (x in 1..5) {
        println(x)
    }
}

/**
 * 数列迭代
 */
fun rangeLoop2() {
    for (x in 1..10 step 2) {
        println(x)
    }
    println("----")
    for (x in 9 downTo 0 step 3) {
        println(x)
    }
}

/**
 * 集合进行迭代
 */
fun collection1() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    //使用 in 运算符来判断集合内是否包含某实例：
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
    //使用 lambda 表达式来过滤（filter）与映射（map）集合
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

/**
 * 建基本类及其实例
 */
fun createCollection() {
//    val rectangle = Rectangle(5.0, 2.0)
//    val triangle = Triangle(3.0, 4.0, 5.0)
}
