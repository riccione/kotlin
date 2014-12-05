import kotlin.test.assertEquals

trait A {
    fun f1(): String
    fun f2(): String
    fun f3(): String
}

fun doWork(block: () -> String) = block()
inline fun doWorkInline(block: () -> String) = block()

fun box(): String {
    val x = object {
        inline fun <reified T> bar1(): A = object : A {
            override fun f1(): String = javaClass<T>().getName()
            override fun f2(): String = doWork { javaClass<T>().getName() }
            override fun f3(): String = doWorkInline { javaClass<T>().getName() }
        }

        inline fun <reified T> bar2() = javaClass<T>().getName()
        inline fun <reified T> bar3() = doWork { javaClass<T>().getName() }
        inline fun <reified T> bar4() = doWorkInline { javaClass<T>().getName() }
    }

    val y: A = x.bar1<String>()
    assertEquals("java.lang.String", y.f1())
    assertEquals("java.lang.String", y.f2())
    assertEquals("java.lang.String", y.f3())


    assertEquals("java.lang.Integer", x.bar2<Int>())
    assertEquals("java.lang.Double", x.bar3<Double>())
    assertEquals("java.lang.Long", x.bar4<Long>())

    return "OK"
}
