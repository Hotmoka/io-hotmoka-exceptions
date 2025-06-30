/*
Copyright 2025 Fausto Spoto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package io.hotmoka.exceptions;

/**
 * A collection of run-time checks on objects, with parametric exception type.
 */
public abstract class Objects {

	private Objects() {}

	/**
     * Checks that the specified object reference is not {@code null}. This
     * method is designed primarily for doing parameter validation in methods
     * and constructors, as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar) {
     *     this.bar = Objects.requireNonNull(bar, IllegalArgumentException::new);
     * }
     * </pre></blockquote>
     *
     * @param <T> the type of the reference
     * @param <E> the type of the exception thrown if {@code obj} is {@code null}
     * @param obj the object reference to check for nullity
     * @param onNull the generator of the exception thrown if {@code obj} is {@code null}
     * @return {@code obj} if not {@code null}
     * @throws E if {@code obj} is {@code null}
     */
    public static <T, E extends Exception> T requireNonNull(T obj, ExceptionSupplierFromMessage<? extends E> onNull) throws E {
        if (obj == null)
            throw onNull.apply("Illegal null value");

        return obj;
    }

    /**
     * Checks that the specified object reference is not {@code null}. This
     * method is designed primarily for doing parameter validation in methods
     * and constructors, as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar) {
     *     this.bar = Objects.requireNonNull(bar, "bar cannot be null", IllegalArgumentException::new);
     * }
     * </pre></blockquote>
     *
     * @param <T> the type of the reference
     * @param <E> the type of the exception thrown if {@code obj} is {@code null}
     * @param obj the object reference to check for nullity
     * @param message the message of the exception thrown if {@code obj} is {@code null}
     * @param onNull the generator of the exception thrown if {@code obj} is {@code null}
     * @return {@code obj} if not {@code null}
     * @throws E if {@code obj} is {@code null}
     */
    public static <T, E extends Exception> T requireNonNull(T obj, String message, ExceptionSupplierFromMessage<? extends E> onNull) throws E {
        if (obj == null)
            throw onNull.apply(message);

        return obj;
    }
}