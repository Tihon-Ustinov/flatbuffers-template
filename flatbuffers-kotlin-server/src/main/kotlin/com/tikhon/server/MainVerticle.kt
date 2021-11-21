package com.tikhon.server

import com.tikhon.server.routes.NotFoundRoute
import com.tikhon.server.routes.UserRoute
import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {
    // Create a Router
    val router = Router.router(vertx)
    val userRoute = UserRoute(router)
    val notFoundRoute = NotFoundRoute(router)





    // Create the HTTP server
    vertx.createHttpServer()
      // Handle every request using the router
      .requestHandler(router)
      // Start listening
      .listen(System.getenv("PORT")?.toIntOrNull() ?: 8080)
      // Print the port
      .onSuccess { server ->
        println("HTTP server started on port " + server.actualPort())
      }
  }
}
