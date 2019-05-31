package com.luyang.annotation;

//import java.lang.annotation.Documented;
//import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InitFields {
	public String valueString() default "111";
	int valueInt() default 111;
}
