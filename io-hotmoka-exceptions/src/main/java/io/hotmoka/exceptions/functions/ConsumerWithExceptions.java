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

package io.hotmoka.exceptions.functions;

/**
 * A consumer that might throw exceptions.
 * 
 * @param <T> the type of the consumed value
 */
public interface ConsumerWithExceptions<T> {

	/**
	 * Consumes the given argument.
	 *
	 * @param t the argument
	 * @throws Throwable any exception thrown by the consumer
	 */
	void accept(T t) throws Throwable;
}