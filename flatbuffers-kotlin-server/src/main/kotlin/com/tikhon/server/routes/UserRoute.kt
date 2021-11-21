package com.tikhon.server.routes

import com.google.flatbuffers.FlatBufferBuilder
import dto.user.Gender
import dto.user.User
import io.vertx.core.buffer.impl.BufferImpl
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import java.nio.ByteBuffer

class UserRoute (router: Router) {
  init {
    router
      .get("/getUser")
      .handler(this::getUser)
    router
      .post("/sendUser")
      .handler(this::sendUser)
  }

  private fun getUser(context: RoutingContext) {
    val builder = FlatBufferBuilder(64)
    val name = builder.createString("Tikhon")
    User.startUser(builder)
    User.addId(builder, 1)
    User.addName(builder, name)
    User.addGender(builder, Gender.Male)
    User.addAge(builder, 22)
    val user = User.endUser(builder)
    builder.finish(user)
    val byteBuffer: ByteBuffer = builder.dataBuffer()
    val buffer = BufferImpl()
    buffer.appendBytes(byteBuffer.array())

    context.response()
      .putHeader("content-type", "application/octet-stream")
      .send(buffer)
  }

  private fun sendUser(context: RoutingContext) {

  }
}
