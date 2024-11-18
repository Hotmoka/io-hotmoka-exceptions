/*
Copyright 2023 Fausto Spoto

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

import java.util.function.Function;

import io.hotmoka.exceptions.functions.FunctionWithExceptions;
import io.hotmoka.exceptions.functions.FunctionWithExceptions1;
import io.hotmoka.exceptions.functions.FunctionWithExceptions2;
import io.hotmoka.exceptions.functions.FunctionWithExceptions3;
import io.hotmoka.exceptions.functions.FunctionWithExceptions4;
import io.hotmoka.exceptions.functions.FunctionWithExceptions5;
import io.hotmoka.exceptions.functions.FunctionWithExceptions6;
import io.hotmoka.exceptions.functions.FunctionWithExceptions7;

/**
 * This class provides a method to transform a function with exceptions
 * into a function, by unchecking its exceptions.
 */
public abstract class UncheckFunction {

	private UncheckFunction() {}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R> Function<T, R> uncheck(FunctionWithExceptions<? super T, ? extends R> wrapped) {
		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					throw new UncheckedException(e);
				}
			}
		};
	}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param <E> the type of exceptions that get unchecked
	 * @param exception the exception tag of {@code E}
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R, E extends Throwable> Function<T, R> uncheck(Class<E> exception, FunctionWithExceptions1<? super T, ? extends R, E> wrapped) {
		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					if (exception.isInstance(e))
						throw new UncheckedException(e);
					else
						throw new RuntimeException("Unexpected exception", e);
				}
			}
		};
	}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param <E1> the first type of exceptions that get unchecked
	 * @param <E2> the second type of exceptions that get unchecked
	 * @param exception1 the exception tag of {@code E1}
	 * @param exception2 the exception tag of {@code E2}
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R, E1 extends Throwable, E2 extends Throwable> Function<T, R> uncheck(Class<E1> exception1, Class<E2> exception2, FunctionWithExceptions2<? super T, ? extends R, E1, E2> wrapped) {
		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					if (exception1.isInstance(e) || exception2.isInstance(e))
						throw new UncheckedException(e);
					else
						throw new RuntimeException("Unexpected exception", e);
				}
			}
		};
	}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param <E1> the first type of exceptions that get unchecked
	 * @param <E2> the second type of exceptions that get unchecked
	 * @param <E3> the third type of exceptions that get unchecked
	 * @param exception1 the exception tag of {@code E1}
	 * @param exception2 the exception tag of {@code E2}
	 * @param exception3 the exception tag of {@code E3}
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R, E1 extends Throwable, E2 extends Throwable, E3 extends Throwable> Function<T, R> uncheck
			(Class<E1> exception1, Class<E2> exception2, Class<E3> exception3, FunctionWithExceptions3<? super T, ? extends R, E1, E2, E3> wrapped) {

		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					if (exception1.isInstance(e) || exception2.isInstance(e) || exception3.isInstance(e))
						throw new UncheckedException(e);
					else
						throw new RuntimeException("Unexpected exception", e);
				}
			}
		};
	}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param <E1> the first type of exceptions that get unchecked
	 * @param <E2> the second type of exceptions that get unchecked
	 * @param <E3> the third type of exceptions that get unchecked
	 * @param <E4> the fourth type of exceptions that get unchecked
	 * @param exception1 the exception tag of {@code E1}
	 * @param exception2 the exception tag of {@code E2}
	 * @param exception3 the exception tag of {@code E3}
	 * @param exception4 the exception tag of {@code E4}
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R, E1 extends Throwable, E2 extends Throwable, E3 extends Throwable, E4 extends Throwable> Function<T, R> uncheck
			(Class<E1> exception1, Class<E2> exception2, Class<E3> exception3, Class<E4> exception4,
					FunctionWithExceptions4<? super T, ? extends R, E1, E2, E3, E4> wrapped) {

		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					if (exception1.isInstance(e) || exception2.isInstance(e) || exception3.isInstance(e) || exception4.isInstance(e))
						throw new UncheckedException(e);
					else
						throw new RuntimeException("Unexpected exception", e);
				}
			}
		};
	}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param <E1> the first type of exceptions that get unchecked
	 * @param <E2> the second type of exceptions that get unchecked
	 * @param <E3> the third type of exceptions that get unchecked
	 * @param <E4> the fourth type of exceptions that get unchecked
	 * @param <E5> the fifth type of exceptions that get unchecked
	 * @param exception1 the exception tag of {@code E1}
	 * @param exception2 the exception tag of {@code E2}
	 * @param exception3 the exception tag of {@code E3}
	 * @param exception4 the exception tag of {@code E4}
	 * @param exception5 the exception tag of {@code E5}
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R, E1 extends Throwable, E2 extends Throwable, E3 extends Throwable, E4 extends Throwable, E5 extends Throwable> Function<T, R> uncheck
			(Class<E1> exception1, Class<E2> exception2, Class<E3> exception3, Class<E4> exception4, Class<E5> exception5,
					FunctionWithExceptions5<? super T, ? extends R, E1, E2, E3, E4, E5> wrapped) {

		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					if (exception1.isInstance(e) || exception2.isInstance(e) || exception3.isInstance(e) || exception4.isInstance(e) || exception5.isInstance(e))
						throw new UncheckedException(e);
					else
						throw new RuntimeException("Unexpected exception", e);
				}
			}
		};
	}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param <E1> the first type of exceptions that get unchecked
	 * @param <E2> the second type of exceptions that get unchecked
	 * @param <E3> the third type of exceptions that get unchecked
	 * @param <E4> the fourth type of exceptions that get unchecked
	 * @param <E5> the fifth type of exceptions that get unchecked
	 * @param <E6> the sixth type of exceptions that get unchecked
	 * @param exception1 the exception tag of {@code E1}
	 * @param exception2 the exception tag of {@code E2}
	 * @param exception3 the exception tag of {@code E3}
	 * @param exception4 the exception tag of {@code E4}
	 * @param exception5 the exception tag of {@code E5}
	 * @param exception6 the exception tag of {@code E6}
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R, E1 extends Throwable, E2 extends Throwable, E3 extends Throwable, E4 extends Throwable, E5 extends Throwable, E6 extends Throwable> Function<T, R> uncheck
			(Class<E1> exception1, Class<E2> exception2, Class<E3> exception3, Class<E4> exception4, Class<E5> exception5, Class<E6> exception6,
					FunctionWithExceptions6<? super T, ? extends R, E1, E2, E3, E4, E5, E6> wrapped) {

		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					if (exception1.isInstance(e) || exception2.isInstance(e) || exception3.isInstance(e) || exception4.isInstance(e) || exception5.isInstance(e) || exception6.isInstance(e))
						throw new UncheckedException(e);
					else
						throw new RuntimeException("Unexpected exception", e);
				}
			}
		};
	}

	/**
	 * Transforms a function with exceptions into a function without checked
	 * exceptions. This means that all checked exceptions get wrapped into
	 * a {@link UncheckedException}. They can later be recovered through
	 * a method from {@link CheckRunnable} or {@link CheckSupplier}.
	 * 
	 * @param <T> the type of the parameter of the function
	 * @param <R> the type of the result of the function
	 * @param <E1> the first type of exceptions that get unchecked
	 * @param <E2> the second type of exceptions that get unchecked
	 * @param <E3> the third type of exceptions that get unchecked
	 * @param <E4> the fourth type of exceptions that get unchecked
	 * @param <E5> the fifth type of exceptions that get unchecked
	 * @param <E6> the sixth type of exceptions that get unchecked
	 * @param <E7> the seventh type of exceptions that get unchecked
	 * @param exception1 the exception tag of {@code E1}
	 * @param exception2 the exception tag of {@code E2}
	 * @param exception3 the exception tag of {@code E3}
	 * @param exception4 the exception tag of {@code E4}
	 * @param exception5 the exception tag of {@code E5}
	 * @param exception6 the exception tag of {@code E6}
	 * @param exception7 the exception tag of {@code E7}
	 * @param wrapped the function with exceptions
	 * @return the function without exceptions
	 */
	public static <T, R, E1 extends Throwable, E2 extends Throwable, E3 extends Throwable, E4 extends Throwable, E5 extends Throwable, E6 extends Throwable, E7 extends Throwable> Function<T, R> uncheck
			(Class<E1> exception1, Class<E2> exception2, Class<E3> exception3, Class<E4> exception4, Class<E5> exception5, Class<E6> exception6, Class<E7> exception7,
					FunctionWithExceptions7<? super T, ? extends R, E1, E2, E3, E4, E5, E6, E7> wrapped) {

		return new Function<>() {

			@Override
			public R apply(T t) {
				try {
					return wrapped.apply(t);
				}
				catch (RuntimeException | Error e) {
					throw e;
				}
				catch (Throwable e) {
					if (e instanceof InterruptedException)
						Thread.currentThread().interrupt();

					if (exception1.isInstance(e) || exception2.isInstance(e) || exception3.isInstance(e) || exception4.isInstance(e) || exception5.isInstance(e) || exception6.isInstance(e) || exception7.isInstance(e))
						throw new UncheckedException(e);
					else
						throw new RuntimeException("Unexpected exception", e);
				}
			}
		};
	}
}