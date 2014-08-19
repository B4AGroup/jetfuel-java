package com.eixox.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIControl {

	UIControlType type();

	String label() default "";

	String hint() default "";

	String placeholder() default "";

	Class<?> source() default Object.class;

	String group() default "";
	
	String formatString() default "";
	
	boolean insertEmptyOption() default false;
	
	Class<?> formatter() default Object.class;
}
