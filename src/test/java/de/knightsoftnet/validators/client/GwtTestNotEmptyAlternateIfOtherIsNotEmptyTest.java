/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package de.knightsoftnet.validators.client;

import de.knightsoftnet.validators.shared.NotEmptyAlternateIfOtherIsNotEmptyTestBean;

public class GwtTestNotEmptyAlternateIfOtherIsNotEmptyTest extends
    AbstractValidationTest<NotEmptyAlternateIfOtherIsNotEmptyTestBean> {


  /**
   * the compare field is empty, alternate fields can be filled in every way.
   */
  public final void testCompareIsEmptyAlternateEverythingIsAllowed() {
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, null, null), true,
        null);
    super
        .validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, "", null), true, null);
    super
        .validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, null, ""), true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, "", ""), true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, "filled", null),
        true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, null, "filled"),
        true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, "filled", "filled"),
        true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, "filled", ""), true,
        null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean(null, "", "filled"), true,
        null);

    super
        .validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", null, null), true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", "", null), true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", null, ""), true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", "", ""), true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", "filled", null), true,
        null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", null, "filled"), true,
        null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", "filled", "filled"),
        true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", "filled", ""), true,
        null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("", "", "filled"), true,
        null);
  }

  /**
   * the compare field is filled, one of the alternate field (or both) have to be set.
   */
  public final void testCompareIsFilledOneOfTheAlternateHasTobEeSetAllowed() {
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", "filled", null),
        true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", null, "filled"),
        true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", "filled",
        "filled"), true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", "filled", ""),
        true, null);
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", "", "filled"),
        true, null);
  }

  /**
   * the compare field is set and both alternate fields are empty.
   */
  public final void testCompareIsFilledBothAlternatesAreEmptyWrong() {
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", null, null),
        false,
        "de.knightsoftnet.validators.shared.impl.NotEmptyAlternateIfOtherIsNotEmptyValidator");
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", "", null), false,
        "de.knightsoftnet.validators.shared.impl.NotEmptyAlternateIfOtherIsNotEmptyValidator");
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", null, ""), false,
        "de.knightsoftnet.validators.shared.impl.NotEmptyAlternateIfOtherIsNotEmptyValidator");
    super.validationTest(new NotEmptyAlternateIfOtherIsNotEmptyTestBean("filled", "", ""), false,
        "de.knightsoftnet.validators.shared.impl.NotEmptyAlternateIfOtherIsNotEmptyValidator");
  }
}
