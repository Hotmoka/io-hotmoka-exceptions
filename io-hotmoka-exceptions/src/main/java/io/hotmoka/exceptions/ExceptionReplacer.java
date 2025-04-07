package io.hotmoka.exceptions;

import java.util.function.Function;

/**
 * A replacer of an exception with another exception. It is a function from the replaced
 * exception to an exception with the same message and having the replaced exception as cause.
 * 
 * @param <Replaced> the type of the replaced exception
 * @param <Replacement> the type of the replacing exception
 */
public interface ExceptionReplacer<Replaced extends Exception, Replacement extends Exception> extends Function<Replaced, Replacement> {
}