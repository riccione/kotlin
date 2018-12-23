// !LANGUAGE: +ProhibitJvmOverloadsOnConstructorsOfAnnotationClasses

annotation class A <!OVERLOADS_ANNOTATION_CLASS_CONSTRUCTOR!>@JvmOverloads<!> constructor(val x: Int = 1)