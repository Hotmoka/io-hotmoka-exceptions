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
 * A consumer that might throw exceptions.
 * 
 * @param <T> the type of the consumed value
 * @param <E1> the first type of exceptions
 * @param <E2> the second type of exceptions
 * @param <E3> the third type of exceptions
 * @param <E4> the fourth type of exceptions
 */
public interface ConsumerWithExceptions4<T, E1 extends Throwable, E2 extends Throwable, E3 extends Throwable, E4 extends Throwable> {

	/**
	 * Consumes the given argument.
	 *
	 * @param t the argument
	 * @throws E1 a first type of exception thrown by the consumer
	 * @throws E2 a second type of exception thrown by the consumer
	 * @throws E3 a third type of exception thrown by the consumer
	 * @throws E4 a fourth type of exception thrown by the consumer
	 */
	void accept(T t) throws E1, E2, E3, E4;
}