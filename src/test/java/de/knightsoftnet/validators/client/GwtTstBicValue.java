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

import de.knightsoftnet.validators.shared.beans.BicValueTestBean;
import de.knightsoftnet.validators.shared.testcases.BicValueTestCases;

/**
 * test for bic validator.
 *
 * @author Manfred Tremmel
 *
 */
public class GwtTstBicValue extends AbstractValidationTst<BicValueTestBean> {

  /**
   * empty bic is allowed.
   */
  public final void testEmptyBicIsAllowed() {
    super.validationTest(BicValueTestCases.getEmptyTestBean(), true, null);
  }

  /**
   * correct bics are allowed.
   */
  public final void testCorrectBicIsAllowed() {
    for (final BicValueTestBean testBean : BicValueTestCases.getCorrectTestBeans()) {
      super.validationTest(testBean, true, null);
    }
  }

  /**
   * bic with country which is not part of SEPA country list.
   */
  public final void testWrongCountryBicIsWrong() {
    for (final BicValueTestBean testBean : BicValueTestCases.getWrongCountryTestBeans()) {
      super.validationTest(testBean, false,
          "de.knightsoftnet.validators.shared.impl.BicValueValidator");
    }
  }

  /**
   * bic with lowercase chars inside.
   */
  public final void testLowerCaseBicIsWrong() {
    for (final BicValueTestBean testBean : BicValueTestCases.getWrongFormatTestBeans()) {
      super.validationTest(testBean, false,
          "de.knightsoftnet.validators.shared.impl.BicValueValidator");
    }
  }

  /**
   * bic is to short.
   */
  public final void testToShortBicIsWrong() {
    for (final BicValueTestBean testBean : BicValueTestCases.getWrongToShortTestBeans()) {
      super.validationTest(testBean, false,
          "de.knightsoftnet.validators.shared.impl.AlternateSizeValidator");
    }
  }

  /**
   * bic is to long.
   */
  public final void testToLongBicIsWrong() {
    for (final BicValueTestBean testBean : BicValueTestCases.getWrongToBigTestBeans()) {
      super.validationTest(testBean, false,
          "de.knightsoftnet.validators.shared.impl.AlternateSizeValidator");
    }
  }
}
