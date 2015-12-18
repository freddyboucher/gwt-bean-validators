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

package de.knightsoftnet.validators.client.handlers;

import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.HasValue;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory Class to get Handlers.
 *
 * @author Manfred Tremmel
 */
public class HandlerFactory {

  private static final Map<String, RegExKeyPressHandler> REG_EX_KEY_PRESS_HANDLER_MAP =
      new HashMap<String, RegExKeyPressHandler>();

  private static UpperAsciiKeyPressHandler upperAsciiKeyPressHandler = null;
  private static NumericAndUpperAsciiKeyPressHandler numericAndUpperAsciiKeyPressHandler = null;
  private static IbanKeyPressHandler ibanKeyPressHandler = null;
  private static IbanKeyUpHandler ibanKeyUpHandler = null;
  private static Isbn10KeyPressHandler isbn10KeyPressHandler = null;
  private static Isbn10KeyUpHandler isbn10KeyUpHandler = null;
  private static Isbn13KeyPressHandler isbn13KeyPressHandler = null;
  private static Isbn13KeyUpHandler isbn13KeyUpHandler = null;
  private static IsbnKeyPressHandler isbnKeyPressHandler = null;
  private static IsbnKeyUpHandler isbnKeyUpHandler = null;
  private static NumericKeyPressHandler numericKeyPressHandler = null;
  private static CurrencyKeyPressHandler currencyKeyPressHandler = null;
  private static PercentKeyPressHandler percentKeyPressHandler = null;
  private static PhoneNumberKeyPressHandler phoneNumberKeyPressHandler = null;
  private static DecimalKeyPressHandler decimalKeyPressHandler = null;

  /**
   * get a upper case key press handler.
   *
   * @return UpperAsciiKeyPressHandler
   */
  public static final UpperAsciiKeyPressHandler getUpperAsciiKeyPressHandler() {
    if (upperAsciiKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      upperAsciiKeyPressHandler = new UpperAsciiKeyPressHandler();
    }
    return upperAsciiKeyPressHandler;
  }

  /**
   * get a numeric and upper case key press handler.
   *
   * @return NumericAndUpperAsciiKeyPressHandler
   */
  public static final NumericAndUpperAsciiKeyPressHandler getNumericAndUpperAsciiKeyPressHandler() {
    if (numericAndUpperAsciiKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      numericAndUpperAsciiKeyPressHandler = new NumericAndUpperAsciiKeyPressHandler();
    }
    return numericAndUpperAsciiKeyPressHandler;
  }

  /**
   * get a iban key press handler.
   *
   * @return IbanKeyPressHandler
   */
  public static final IbanKeyPressHandler getIbanKeyPressHandler() {
    if (ibanKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      ibanKeyPressHandler = new IbanKeyPressHandler();
    }
    return ibanKeyPressHandler;
  }

  /**
   * get a iban key up handler.
   *
   * @return IbanKeyUpHandler
   */
  public static final IbanKeyUpHandler getIbanKeyUpHandler() {
    if (ibanKeyUpHandler == null) { // NOPMD, needn't be thread save on client
      ibanKeyUpHandler = new IbanKeyUpHandler();
    }
    return ibanKeyUpHandler;
  }

  /**
   * get a isbn 10 key press handler.
   *
   * @return Isbn10KeyPressHandler
   */
  public static final Isbn10KeyPressHandler getIsbn10KeyPressHandler() {
    if (isbn10KeyPressHandler == null) { // NOPMD, needn't be thread save on client
      isbn10KeyPressHandler = new Isbn10KeyPressHandler();
    }
    return isbn10KeyPressHandler;
  }

  /**
   * get a isbn 10 key up handler.
   *
   * @return Isbn10KeyUpHandler
   */
  public static final Isbn10KeyUpHandler getIsbn10KeyUpHandler() {
    if (isbn10KeyUpHandler == null) { // NOPMD, needn't be thread save on client
      isbn10KeyUpHandler = new Isbn10KeyUpHandler();
    }
    return isbn10KeyUpHandler;
  }

  /**
   * get a isbn 13 key press handler.
   *
   * @return Isbn13KeyPressHandler
   */
  public static final Isbn13KeyPressHandler getIsbn13KeyPressHandler() {
    if (isbn13KeyPressHandler == null) { // NOPMD, needn't be thread save on client
      isbn13KeyPressHandler = new Isbn13KeyPressHandler();
    }
    return isbn13KeyPressHandler;
  }

  /**
   * get a isbn 13 key up handler.
   *
   * @return Isbn13KeyUpHandler
   */
  public static final Isbn13KeyUpHandler getIsbn13KeyUpHandler() {
    if (isbn13KeyUpHandler == null) { // NOPMD, needn't be thread save on client
      isbn13KeyUpHandler = new Isbn13KeyUpHandler();
    }
    return isbn13KeyUpHandler;
  }

  /**
   * get a isbn key press handler.
   *
   * @return IsbnKeyPressHandler
   */
  public static final IsbnKeyPressHandler getIsbnKeyPressHandler() {
    if (isbnKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      isbnKeyPressHandler = new IsbnKeyPressHandler();
    }
    return isbnKeyPressHandler;
  }

  /**
   * get a isbn key up handler.
   *
   * @return IsbnKeyUpHandler
   */
  public static final IsbnKeyUpHandler getIsbnKeyUpHandler() {
    if (isbnKeyUpHandler == null) { // NOPMD, needn't be thread save on client
      isbnKeyUpHandler = new IsbnKeyUpHandler();
    }
    return isbnKeyUpHandler;
  }

  /**
   * get a numeric key press handler.
   *
   * @return NumericKeyPressHandler
   */
  public static final NumericKeyPressHandler getNumericKeyPressHandler() {
    if (numericKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      numericKeyPressHandler = new NumericKeyPressHandler();
    }
    return numericKeyPressHandler;
  }

  /**
   * get a currency key press handler.
   *
   * @return CurrencyKeyPressHandler
   */
  public static final CurrencyKeyPressHandler getCurrencyKeyPressHandler() {
    if (currencyKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      currencyKeyPressHandler = new CurrencyKeyPressHandler();
    }
    return currencyKeyPressHandler;
  }

  /**
   * get a percent key press handler.
   *
   * @return PercentKeyPressHandler
   */
  public static final PercentKeyPressHandler getPercentKeyPressHandler() {
    if (percentKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      percentKeyPressHandler = new PercentKeyPressHandler();
    }
    return percentKeyPressHandler;
  }

  /**
   * get a phone number key press handler.
   *
   * @return PhoneNumberKeyPressHandler
   */
  public static final PhoneNumberKeyPressHandler getPhoneNumberKeyPressHandler() {
    if (phoneNumberKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      phoneNumberKeyPressHandler = new PhoneNumberKeyPressHandler();
    }
    return phoneNumberKeyPressHandler;
  }

  /**
   * get a phone number key press handler.
   *
   * @param pcountryCodeField reference to country code field
   * @return PhoneNumberDin5008KeyPressHandler
   */
  public static KeyPressHandler getPhoneNumberDin5008KeyPressHandler(
      final HasValue<?> pcountryCodeField) {
    return new PhoneNumberDin5008KeyPressHandler(pcountryCodeField);
  }

  /**
   * get a phone number key up handler.
   *
   * @param pcountryCodeField reference to country code field
   * @return PhoneNumberDin5008KeyUpHandler
   */
  public static PhoneNumberDin5008KeyUpHandler getPhoneNumberDin5008KeyUpHandler(
      final HasValue<?> pcountryCodeField) {
    return new PhoneNumberDin5008KeyUpHandler(pcountryCodeField);
  }

  /**
   * get a phone number key press handler.
   *
   * @param pcountryCodeField reference to country code field
   * @return PhoneNumberMsKeyPressHandler
   */
  public static KeyPressHandler getPhoneNumberMsKeyPressHandler(
      final HasValue<?> pcountryCodeField) {
    return new PhoneNumberMsKeyPressHandler(pcountryCodeField);
  }

  /**
   * get a phone number key up handler.
   *
   * @param pcountryCodeField reference to country code field
   * @return PhoneNumberMsKeyUpHandler
   */
  public static PhoneNumberMsKeyUpHandler getPhoneNumberMsKeyUpHandler(
      final HasValue<?> pcountryCodeField) {
    return new PhoneNumberMsKeyUpHandler(pcountryCodeField);
  }

  /**
   * get a decimal key press handler.
   *
   * @return DecimalKeyPressHandler
   */
  public static final DecimalKeyPressHandler getDecimalKeyPressHandler() {
    if (decimalKeyPressHandler == null) { // NOPMD, needn't be thread save on client
      decimalKeyPressHandler = new DecimalKeyPressHandler();
    }
    return decimalKeyPressHandler;
  }

  /**
   * get a key press handler which allows all characters which could match a reg ex.
   *
   * @param pregEx to check
   * @return key press handler
   */
  public static final RegExKeyPressHandler getRegExKeyPressHandler(final String pregEx) {
    if (StringUtils.isEmpty(pregEx)) {
      return null;
    }
    RegExKeyPressHandler result = REG_EX_KEY_PRESS_HANDLER_MAP.get(pregEx);
    if (result == null) {
      result = new RegExKeyPressHandler(pregEx);
    }
    return result;
  }

  /**
   * get a key press handler which allows characters for postal codes of a referenced country.
   *
   * @param pcountryCodeField reference to country code field
   * @return key press handler
   */
  public static final PostalCodeKeyPressHandler getPostalCodeKeyPressHandler(
      final HasValue<?> pcountryCodeField) {
    return new PostalCodeKeyPressHandler(pcountryCodeField);
  }
}
