// !LANGUAGE: -ProhibitJvmOverloadsOnConstructorsOfAnnotationClasses

annotation class A <!OVERLOADS_ANNOTATION_CLASS_CONSTRUCTOR_WARNING!>@JvmOverloads<!> constructor(val x: Int = 1)