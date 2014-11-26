package spray.oauth.endpoints

import org.specs2.mutable.Specification
import spray.oauth.adapters.inmemory.SprayOAuth2Support
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class OAuth2ServicesSpec extends Specification with Specs2RouteTest with OAuth2Services with SprayOAuth2Support {
  def actorRefFactory = system

  "TokenService" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> defaultTokenRoutes ~> check {
        responseAs[String] must contain("Say hello")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> defaultTokenRoutes ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put() ~> sealRoute(defaultTokenRoutes) ~> check {
        status === MethodNotAllowed
        responseAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
