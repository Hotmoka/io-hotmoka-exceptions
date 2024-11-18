/*
Copyright 2024 Fausto Spoto

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

package io.hotmoka.exceptions.functions;

/**
 * A function that might throw exceptions.
 * 
 * @param <T> the type of the parameter of the function
 * @param <R> the type of the result of the function
 * @param <E1> the first type of exceptions
 * @param <E2> the second type of exceptions
 */
public interface FunctionWithExceptions2<T, R, E1 extends Throwable, E2 extends Throwable> {

	/**
	 * Applies the function.
	 * 
	 * @param t the argument to the function
	 * @return the result of the function
	 * @throws E1 a first type of exceptions thrown by the function
	 * @throws E2 a second type of exceptions thrown by the function
	 */
	R apply(T t) throws E1, E2;
}