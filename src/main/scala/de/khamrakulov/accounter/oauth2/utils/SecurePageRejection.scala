package de.khamrakulov.accounter.oauth2.utils

import spray.routing.{ Rejection, AuthenticationFailedRejection }
import spray.http.{ Uri, HttpHeader }

case class SecurePageRejection(uri: Uri) extends Rejection