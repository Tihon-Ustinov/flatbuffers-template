package com.tikhon.flatbuffers_kotlin_server

import com.tikhon.server.MainVerticle
import com.tikhon.server.routes.NotFoundRoute
import com.tikhon.server.routes.UserRoute
import io.vertx.core.Handler
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClientRequest
import io.vertx.core.http.HttpClientResponse
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(VertxExtension::class)
class TestMainVerticle {

  @BeforeEach
  fun deploy_verticle(vertx: Vertx, testContext: VertxTestContext) {
    vertx.deployVerticle(MainVerticle(), testContext.succeeding<String> { _ -> testContext.completeNow() })
  }

  @Test
  fun verticle_deployed(vertx: Vertx, testContext: VertxTestContext) {
    testContext.completeNow()
  }

  @Test
  fun notFoundPage(vertx: Vertx, testContext: VertxTestContext) {
    val router = Router.router(vertx)
    val notFoundRoute = NotFoundRoute(router)
    val userRoute = UserRoute(router)
    val client = vertx.createHttpClient()
    TODO("End test not found response")
//    client.request(HttpMethod.GET, 8080, "localhost", "/")
//      .compose { req: HttpClientRequest ->
//        req.send().compose { obj: HttpClientResponse -> obj.body() }
//      }
//      .onComplete(testContext.succeeding { buffer ->
//        testContext.verify {
//          println(buffer.toString())
////          assertThat(buffer.toString()).isEqualTo("Plop")
//          testContext.completeNow()
//        }
//      })
  }
}
