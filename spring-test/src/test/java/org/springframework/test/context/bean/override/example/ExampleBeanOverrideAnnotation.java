/*
 * Copyright 2002-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.test.context.bean.override.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.bean.override.BeanOverride;

@BeanOverride(ExampleBeanOverrideProcessor.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExampleBeanOverrideAnnotation {

	String DEFAULT_VALUE = "TEST OVERRIDE";
	// Any metadata using this as the prefix for the bean name will be considered equal
	String DUPLICATE_TRIGGER = "DUPLICATE";

	String value() default DEFAULT_VALUE;

	boolean createIfMissing() default false;

	String beanName() default "";
}
