package com.ky0dai

import java.util.concurrent.TimeUnit

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http

/**
 * Created by kyodai on 1/25/2016.
 */

object App {

  def main(args : Array[String]): Unit = {

    println("Initializing...")
    implicit val actorSystem = ActorSystem("on-spray-can")

    val webService = actorSystem.actorOf(Props[DiscountProviderActor])

    println("hosted!")

    implicit val timeout = Timeout(10, TimeUnit.SECONDS)
    IO(Http) ? Http.Bind(webService, interface = "localhost", port = 2117)

  }

}
