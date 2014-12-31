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

package de.knightsoftnet.validators.shared.impl;

import de.knightsoftnet.validators.shared.PostalCode;
import de.knightsoftnet.validators.shared.data.PostalCodeDefinitions;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Check if a postal code field is valid for the selected country.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class PostalCodeValidator implements ConstraintValidator<PostalCode, Object> {

  /**
   * error message key.
   */
  private String message;

  /**
   * field name of the country code field.
   */
  private String fieldCountryCode;

  /**
   * field name of the postal code (zip) field.
   */
  private String fieldPostalCode;

  /**
   * {@inheritDoc} initialize the validator.
   *
   * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
   */
  @Override
  public final void initialize(final PostalCode pconstraintAnnotation) {
    this.message = pconstraintAnnotation.message();
    this.fieldCountryCode = pconstraintAnnotation.fieldCountryCode();
    this.fieldPostalCode = pconstraintAnnotation.fieldPostalCode();
  }

  /**
   * {@inheritDoc} check if given object.
   *
   * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
   *      javax.validation.ConstraintValidatorContext)
   */
  @Override
  public final boolean isValid(final Object pvalue, final ConstraintValidatorContext pcontext) {
    try {
      final String countryCode = BeanUtils.getProperty(pvalue, this.fieldCountryCode);
      final String postalCode = BeanUtils.getProperty(pvalue, this.fieldPostalCode);
      if (StringUtils.isEmpty(postalCode)) {
        return true;
      }

      final String regExCheck = PostalCodeDefinitions.COUNTRY_POSTAL_CODE_REGEX.get(countryCode);
      if (regExCheck == null) {
        return true;
      }
      if (postalCode.matches(regExCheck)) {
        return true;
      }
      pcontext.disableDefaultConstraintViolation();
      pcontext.buildConstraintViolationWithTemplate(this.message).addNode(this.fieldPostalCode)
          .addConstraintViolation();
      return false;
    } catch (final Exception ignore) {
      return false;
    }
  }
}
