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

package de.knightsoftnet.validators.shared.data;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * phone number data.
 *
 * @author Manfred Tremmel
 *
 */
public class PhoneNumberData implements Serializable {
  private static final long serialVersionUID = -5715038613377873088L;

  private String countryCode;
  private String countryName;
  private String areaCode;
  private String areaName;
  private String phoneNumber;
  private String extension;

  /**
   * default constructor.
   */
  public PhoneNumberData() {
    super();
  }

  /**
   * constructor initializing fields.
   *
   * @param pcountryCode country code
   * @param pareaCode area code
   * @param pphoneNumber phone number
   * @param pextension extension
   */
  public PhoneNumberData(final String pcountryCode, final String pareaCode,
      final String pphoneNumber, final String pextension) {
    super();
    this.countryCode = pcountryCode;
    this.areaCode = pareaCode;
    this.phoneNumber = pphoneNumber;
    this.extension = pextension;
  }


  public String getCountryCode() {
    return this.countryCode;
  }

  public void setCountryCode(final String pcountryCode) {
    this.countryCode = pcountryCode;
  }

  public String getCountryName() {
    return this.countryName;
  }

  public void setCountryName(final String pcountryName) {
    this.countryName = pcountryName;
  }

  public String getAreaCode() {
    return this.areaCode;
  }

  public void setAreaCode(final String pareaCode) {
    this.areaCode = pareaCode;
  }

  public String getAreaName() {
    return this.areaName;
  }

  public void setAreaName(final String pareaName) {
    this.areaName = pareaName;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(final String pphoneNumber) {
    this.phoneNumber = pphoneNumber;
  }

  public String getExtension() {
    return this.extension;
  }

  public void setExtension(final String pextension) {
    this.extension = pextension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (this.areaCode == null ? 0 : this.areaCode.hashCode());
    result = prime * result + (this.countryCode == null ? 0 : this.countryCode.hashCode());
    result = prime * result + (this.extension == null ? 0 : this.extension.hashCode());
    result = prime * result + (this.phoneNumber == null ? 0 : this.phoneNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object pobj) {
    if (this == pobj) {
      return true;
    }
    if (pobj == null) {
      return false;
    }
    if (this.getClass() != pobj.getClass()) {
      return false;
    }
    final PhoneNumberData other = (PhoneNumberData) pobj;
    return StringUtils.equals(this.countryCode, other.countryCode)
        && StringUtils.equals(this.areaCode, other.areaCode)
        && StringUtils.equals(this.phoneNumber, other.phoneNumber)
        && StringUtils.equals(this.extension, other.extension);
  }

  @Override
  public String toString() {
    return "PhoneNumberData [countryCode=" + this.countryCode + ", areaCode=" + this.areaCode
        + ", phoneNumber=" + this.phoneNumber + ", extension=" + this.extension + "]";
  }
}
