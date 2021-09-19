package com.demo.heroes.adapter.input.web.hero.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NumberValidator.class})
public @interface NumberValid {

  /**
   * message method description.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  String message() default "is invalid";

  /**
   * required field flag.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  boolean required() default false;

  /**
   * groups method description.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  Class<?>[] groups() default {};

  /**
   * payload method description.
   *
   * <pre>
   * &lt;module name=&quot;NonEmptyAtclauseDescription&quot;/&gt;
   * </pre>
   */
  Class<? extends Payload>[] payload() default {};
}
