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

import de.knightsoftnet.validators.shared.Bic;

import org.junit.Test;

public class BicTest extends AbstractValidationTest<BicTest.BicTestBean> {

  public class BicTestBean {

    @Bic
    private final String bic;

    public BicTestBean(final String pbic) {
      super();
      this.bic = pbic;
    }

    public String getBic() {
      return this.bic;
    }
  }

  /**
   * empty bic is allowed.
   */
  @Test
  public final void testEmptyBicIsAllowed() {
    super.validationTest(new BicTestBean(null), true, null);
  }

  /**
   * correct bics are allowed.
   */
  @Test
  public final void testCorrectBicIsAllowed() {
    super.validationTest(new BicTestBean("GENODEFF701"), true, null);
    super.validationTest(new BicTestBean("GENODEM1GLS"), true, null);
    super.validationTest(new BicTestBean("GIBAATWWXXX"), true, null);
    super.validationTest(new BicTestBean("POFICHBEXXX"), true, null);
    super.validationTest(new BicTestBean("CCRTIT21"), true, null);
  }

  /**
   * bic with country which is not part of SEPA country list.
   */
  @Test
  public final void testWrongCountryBicIsWrong() {
    super.validationTest(new BicTestBean("GENOXYFF701"), false,
        "de.knightsoftnet.validators.shared.impl.BicValidator");
  }

  /**
   * bic with lowercase chars inside.
   */
  @Test
  public final void testLowerCaseBicIsWrong() {
    super.validationTest(new BicTestBean("GeNODEFF701"), false,
        "de.knightsoftnet.validators.shared.impl.BicValidator");
  }

  /**
   * bic is to short.
   */
  @Test
  public final void testToShortBicIsWrong() {
    super.validationTest(new BicTestBean("GENODEFF70"), false,
        "de.knightsoftnet.validators.shared.impl.AlternateSizeValidator");
  }

  /**
   * bic is to long.
   */
  @Test
  public final void testToLongBicIsWrong() {
    super.validationTest(new BicTestBean("GENODEFF7012"), false,
        "de.knightsoftnet.validators.shared.impl.AlternateSizeValidator");
  }
}
