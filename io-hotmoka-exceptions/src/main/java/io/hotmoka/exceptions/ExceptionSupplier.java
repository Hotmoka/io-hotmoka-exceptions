package io.hotmoka.exceptions;

import java.util.function.Supplier;

/**
 * A supplier of an exception.
 * 
 * @param <E> the type of the supplied exception
 */
public interface ExceptionSupplier<E extends Exception> extends Supplier<E> {
}