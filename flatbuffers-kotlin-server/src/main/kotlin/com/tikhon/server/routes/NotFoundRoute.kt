package com.tikhon.server.routes

import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext

class NotFoundRoute(router: Router) {
  init {
    router
      .route()
      .handler(this::route)
  }

  private fun route(context: RoutingContext) {
    val message = """
        This route not found
        move to <a href="/getUser">getUser</a> to get flatbuffer user
        or move to <a href="/sendUser">sendUser</a> to flatbuffer user
      """.trimIndent()
    context.response()
      .putHeader("content-type", "text/html")
      .end(message)
  }
}
