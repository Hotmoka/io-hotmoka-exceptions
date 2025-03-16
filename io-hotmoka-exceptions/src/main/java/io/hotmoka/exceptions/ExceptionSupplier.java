package io.hotmoka.exceptions;

import java.util.function.Function;

/**
 * A supplier of an exception. It is a function from the message of the exception
 * to the supplied exception.
 * 
 * @param <E> the type of the supplied exception
 */
public interface ExceptionSupplier<E extends Exception> extends Function<String, E> {
}