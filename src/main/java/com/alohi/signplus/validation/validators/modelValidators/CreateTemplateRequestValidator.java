package com.alohi.signplus.validation.validators.modelValidators;

import com.alohi.signplus.models.CreateTemplateRequest;
import com.alohi.signplus.validation.Violation;
import com.alohi.signplus.validation.ViolationAggregator;
import com.alohi.signplus.validation.validators.StringValidator;

public class CreateTemplateRequestValidator extends AbstractModelValidator<CreateTemplateRequest> {

  public CreateTemplateRequestValidator(String fieldName) {
    super(fieldName);
  }

  public CreateTemplateRequestValidator() {}

  @Override
  protected Violation[] validateModel(CreateTemplateRequest createTemplateRequest) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(256)
          .pattern("^[a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$")
          .required()
          .validate(createTemplateRequest.getName())
      )
      .aggregate();
  }
}
