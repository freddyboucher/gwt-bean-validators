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

import de.knightsoftnet.validators.shared.NotEmptyAlternateIfOtherHasValue;
import de.knightsoftnet.validators.shared.interfaces.HasGetFieldByName;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Check if a field is filled if another field is empty.
 *
 * @author Manfred Tremmel
 *
 */
public class NotEmptyAlternateIfOtherHasValueValidator implements
    ConstraintValidator<NotEmptyAlternateIfOtherHasValue, HasGetFieldByName> {

  /**
   * error message key.
   */
  private String message;
  /**
   * field name to check.
   */
  private String fieldCheckName;
  /**
   * alternate field name to check.
   */
  private String fieldAlternateCheckName;
  /**
   * field name to compare.
   */
  private String fieldCompareName;
  /**
   * field name to compare.
   */
  private String valueCompare;

  /**
   * {@inheritDoc} initialize the validator.
   *
   * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
   */
  @Override
  public final void initialize(final NotEmptyAlternateIfOtherHasValue pconstraintAnnotation) {
    this.message = pconstraintAnnotation.message();
    this.fieldCheckName = pconstraintAnnotation.field();
    this.fieldAlternateCheckName = pconstraintAnnotation.fieldAlternate();
    this.fieldCompareName = pconstraintAnnotation.fieldCompare();
    this.valueCompare = pconstraintAnnotation.valueCompare();
  }

  /**
   * {@inheritDoc} check if given object.
   *
   * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
   *      javax.validation.ConstraintValidatorContext)
   */
  @Override
  public final boolean isValid(final HasGetFieldByName pvalue,
      final ConstraintValidatorContext pcontext) {
    try {
      // final String fieldCheckValue = BeanUtils.getProperty(pValue,
      // this.fieldCheckName);
      final String fieldCheckValue =
          Objects.toString(pvalue.getFieldByName(this.fieldCheckName), null);
      final String fieldAlternateCheckValue =
          Objects.toString(pvalue.getFieldByName(this.fieldAlternateCheckName), null);
      final String fieldCompareValue =
          Objects.toString(pvalue.getFieldByName(this.fieldCompareName), null);
      if (StringUtils.isEmpty(fieldCheckValue) && StringUtils.isEmpty(fieldAlternateCheckValue)
          && StringUtils.equals(this.valueCompare, fieldCompareValue)) {
        pcontext.disableDefaultConstraintViolation();
        pcontext.buildConstraintViolationWithTemplate(this.message).addNode(this.fieldCheckName)
            .addConstraintViolation();
        pcontext.buildConstraintViolationWithTemplate(this.message)
            .addNode(this.fieldAlternateCheckName).addConstraintViolation();
        return false;
      }
      return true;
    } catch (final Exception ignore) {
      return false;
    }
  }
}
