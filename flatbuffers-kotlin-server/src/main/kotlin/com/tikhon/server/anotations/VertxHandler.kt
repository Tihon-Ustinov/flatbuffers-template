package com.tikhon.server.anotations

@Target(AnnotationTarget.FUNCTION)
annotation class VertxHandler(val route: String)
