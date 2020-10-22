package kotlindemo.classdemo

/**
 * 主构造函数不能包含任何的代码。
 * 初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
 */
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}