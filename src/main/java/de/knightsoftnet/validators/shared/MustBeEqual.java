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

package de.knightsoftnet.validators.shared;

import de.knightsoftnet.validators.shared.impl.MustBeEqualValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The annotated bean must contain at least two properties:
 * <ul>
 * <li>a field to compare (option <code>field1</code>)</li>
 * <li>another field to compared (option <code>field2</code>)</li>
 * </ul>
 * the entry of <code>field1</code> must be equal to the entry of <code>field2</code>, can be used
 * e.g. for password and password repeat fields.<br />
 * Supported types are beans, <code>null</code> elements are considered valid.<br />
 *
 * @author Manfred Tremmel
 *
 */
@Documented
@Constraint(validatedBy = MustBeEqualValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MustBeEqual {
  /**
   * localized message.
   */
  String message() default "{deKnightsoftnetValidatorsSharedValidationMustBeEqualMessage}";

  /**
   * groups to use.
   */
  Class<?>[] groups() default {};

  /**
   * field1 name to compare.
   */
  String field1();

  /**
   * field2 name to compare.
   */
  String field2();

  /**
   * payload whatever.
   */
  Class<? extends Payload>[] payload() default {};

  /**
   * Defines several {@code MustBeEqual} annotations on the same element.
   */
  @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  public @interface List {
    /**
     * must be equal value.
     */
    MustBeEqual[] value();
  }
}
