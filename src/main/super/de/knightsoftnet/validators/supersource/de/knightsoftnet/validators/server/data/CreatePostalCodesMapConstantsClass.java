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

package de.knightsoftnet.validators.server.data;

import de.knightsoftnet.validators.client.data.PostalCodesMapConstants;
import de.knightsoftnet.validators.shared.data.PostalCodesMapSharedConstants;

import com.google.gwt.core.client.GWT;

/**
 * Read gwt constants from properties file on client side.
 *
 * @author Manfred Tremmel
 *
 */
public class CreatePostalCodesMapConstantsClass {

  private static volatile PostalCodesMapConstants postalCodesMapConstants = null;

  /**
   * Instantiates a class via deferred binding.
   *
   * @return the new instance, which must be cast to the requested class
   */
  public static PostalCodesMapSharedConstants create() {
    if (postalCodesMapConstants == null) { // NOPMD it's thread save!
      synchronized (PostalCodesMapConstants.class) {
        if (postalCodesMapConstants == null) {
          postalCodesMapConstants = GWT.create(PostalCodesMapConstants.class);
        }
      }
    }
    return postalCodesMapConstants;
  }
}
