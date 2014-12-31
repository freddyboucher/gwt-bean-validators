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

import de.knightsoftnet.validators.shared.interfaces.HasGetFieldByName;

@EmptyIfOtherIsNotEmpty.List({
    @EmptyIfOtherIsNotEmpty(field = "street", fieldCompare = "postOfficeBox"),
    @EmptyIfOtherIsNotEmpty(field = "postOfficeBox", fieldCompare = "street"),})
public class EmptyIfOtherIsNotEmptyTestBean implements HasGetFieldByName {
  private final String street;

  private final String postOfficeBox;

  /**
   * constructor initializing fields.
   *
   * @param pstreet street to set
   * @param ppostOfficeBox post office box to set
   */
  public EmptyIfOtherIsNotEmptyTestBean(final String pstreet, final String ppostOfficeBox) {
    super();
    this.street = pstreet;
    this.postOfficeBox = ppostOfficeBox;
  }

  public String getStreet() {
    return this.street;
  }

  public String getPostOfficeBox() {
    return this.postOfficeBox;
  }

  @Override
  public final Object getFieldByName(final String pname) {
    if (pname != null) {
      switch (pname) {
        case "street":
          return this.street;
        case "postOfficeBox":
          return this.postOfficeBox;
        default:
          return null;
      }
    }
    return null;
  }
}
