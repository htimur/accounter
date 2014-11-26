package de.khamrakulov.accounter.oauth2.routes

import spray.oauth.adapters.inmemory.SprayOAuth2Support
import spray.oauth.authentication.ResourceAuthenticator
import spray.routing.HttpService
import scala.concurrent.ExecutionContext.Implicits.global

trait ApiRoutes extends SprayOAuth2Support with ResourceAuthenticator with HttpService {
  val apiRoutes =
    path("user") {
      get {
        authenticate(tokenAuthenticator) { info =>
          authorize(allowedScopes(info, "membership", "membership.readonly")) {
            complete("Success")
          }
        }
      }
    }
}