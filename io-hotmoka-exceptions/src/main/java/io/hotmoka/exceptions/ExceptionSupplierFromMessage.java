package io.hotmoka.exceptions;

import java.util.function.Function;

/**
 * A supplier of an exception from its message.
 * 
 * @param <E> the type of the supplied exception
 */
public interface ExceptionSupplierFromMessage<E extends Exception> extends Function<String, E> {
}