/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0 See the license.txt file in the root directory or
 * <http://www.apache.org/licenses/LICENSE-2.0>.
 */

package org.hibernate.validator.internal.constraintvalidators.bv.future;

import de.knightsoftnet.validators.client.constraints.AbstractNotGwtCompatibleValidator;

import org.hibernate.validator.internal.util.IgnoreJava6Requirement;

import javax.validation.constraints.Future;

/**
 * Check if Joda Time type who implements {@code org.joda.time.ReadablePartial} is in the future.
 *
 * @author Kevin Pollet &lt;kevin.pollet@serli.com&gt; (C) 2011 SERLI
 * @author Manfred Tremmel - GWT port
 */
@IgnoreJava6Requirement
public class FutureValidatorForReadablePartial
    extends AbstractNotGwtCompatibleValidator<Future, Object> {
}
