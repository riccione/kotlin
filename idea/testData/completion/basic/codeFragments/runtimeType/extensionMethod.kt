fun main(args: Array<String>) {
    val b: Base = Derived()
    <caret>val a = 1
}

open class Base {
}

class Derived: Base() {
}

fun Derived.funExtDerived() { }
fun Base.funExtBase() { }

// INVOCATION_COUNT: 1
// EXIST: funExtBase, funExtDerived
// NUMBER: 2


// RUNTIME_TYPE: Derived