package com.demo.heroes.adapter.input.web.hero.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class NameValidator implements ConstraintValidator<NameValid, String> {

  private boolean required;

  @Override
  public void initialize(NameValid searchValid) {
    this.required = searchValid.required();
  }

  @Override
  public boolean isValid(String search, ConstraintValidatorContext context) {
    if (required) {
      return !StringUtils.isBlank(search);
    } else if (StringUtils.isBlank(search)) {
      return true;
    }
    Pattern p = Pattern.compile("^[a-zA-Z0-9 ]*$");
    Matcher m = p.matcher(search.trim());
    return m.matches();
  }
}
