package com.ky0dai

import akka.actor.{Actor, ActorRefFactory}
import spray.http.MediaTypes
import spray.routing.HttpService

/**
 * Created by kyodai on 1/25/2016.
 */
trait DiscountProviderService extends HttpService {
  private val discountResourceGenerator = new DiscountResourceGenerator

  val route = path("") {
    get(respondWithMediaType(MediaTypes.`application/xml`) {
      complete(discountResourceGenerator.getWebPromotionResource)
    })
  }
}

class DiscountProviderActor extends Actor with DiscountProviderService {
  override def receive: Actor.Receive = runRoute(route)

  override def actorRefFactory: ActorRefFactory = context
}
