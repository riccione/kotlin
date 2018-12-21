// TARGET_BACKEND: JVM
// WITH_RUNTIME

import java.util.concurrent.atomic.AtomicReference

fun box(): String {
    val t = AtomicReference(0.toUByte()).get().javaClass.toString()
    if (t != "class kotlin.UByte") throw AssertionError(t)

    return "OK"
}