package com.alohi.signplus.validation.validators;

import com.alohi.signplus.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
