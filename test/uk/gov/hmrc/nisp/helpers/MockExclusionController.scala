/*
 * Copyright 2019 HM Revenue & Customs
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

import org.scalatest.mock.MockitoSugar.mock
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.nisp.controllers.ExclusionController
import uk.gov.hmrc.nisp.fixtures.MockApplicationConfig
import uk.gov.hmrc.nisp.services.StatePensionConnection
import uk.gov.hmrc.nisp.utils.MockTemplateRenderer
import uk.gov.hmrc.play.partials.CachedStaticHtmlPartialRetriever
import uk.gov.hmrc.renderer.TemplateRenderer


object MockExclusionController extends ExclusionController (
  nationalInsuranceService = MockNationalInsuranceServiceViaNationalInsurance,
  citizenDetailsService = MockCitizenDetailsService,
  statePensionConnection = mock[StatePensionConnection],
  applicationConfig = MockApplicationConfig.appConfig,
  authConnector = MockAuthConnector
)(MockCachedStaticHtmlPartialRetriever,
  MockFormPartialRetriever,
  MockTemplateRenderer,
  mock[HeaderCarrier]
) {

  override implicit val cachedStaticHtmlPartialRetriever: CachedStaticHtmlPartialRetriever = MockCachedStaticHtmlPartialRetriever
  override implicit val templateRenderer: TemplateRenderer = MockTemplateRenderer
}
