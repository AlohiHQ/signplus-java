package com.alohi.signplus.validation.validators.modelValidators;

import com.alohi.signplus.models.CreateEnvelopeRequest;
import com.alohi.signplus.validation.Violation;
import com.alohi.signplus.validation.ViolationAggregator;
import com.alohi.signplus.validation.validators.StringValidator;

public class CreateEnvelopeRequestValidator extends AbstractModelValidator<CreateEnvelopeRequest> {

  public CreateEnvelopeRequestValidator(String fieldName) {
    super(fieldName);
  }

  public CreateEnvelopeRequestValidator() {}

  @Override
  protected Violation[] validateModel(CreateEnvelopeRequest createEnvelopeRequest) {
    return new ViolationAggregator()
      .add(
        new StringValidator("name")
          .minLength(2)
          .maxLength(256)
          .pattern("^[a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$")
          .required()
          .validate(createEnvelopeRequest.getName())
      )
      .aggregate();
  }
}
