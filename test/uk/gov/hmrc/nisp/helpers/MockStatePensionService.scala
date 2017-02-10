/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.nisp.helpers

import org.joda.time.{DateTime, LocalDate}
import uk.gov.hmrc.nisp.connectors.{NispConnector, StatePensionConnector}
import uk.gov.hmrc.nisp.services.{NispConnectionSP, StatePensionConnection, StatePensionService}

object MockStatePensionServiceViaNisp extends StatePensionService with NispConnectionSP {
  override val nisp: NispConnector = MockNispConnector

  override def now: () => DateTime = () => new DateTime(new LocalDate(2016, 11, 1))
}


object MockStatePensionServiceViaStatePension extends StatePensionService with StatePensionConnection {
  override def now: () => DateTime = () => new DateTime(new LocalDate(2016, 11, 1))

  override val statePensionConnector: StatePensionConnector = MockStatePensionConnector
}