package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

class ChedaDocumentCheckResultValidatorTest {

  private ChedaDocumentCheckResultValidator validator;
  private ConsignmentCheck check;

  @BeforeEach
  void setUp() {
    validator = new ChedaDocumentCheckResultValidator();
    check = new ConsignmentCheck();
    validator.initialize(null);
  }

  @Test
  void isValid_returnsTrue_whenConsignmentCheckIsNull() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void isValid_returnsFalse_whenDocCheckResultIsNull() {
    check.setDocumentCheckResult(null);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @ParameterizedTest
  @EnumSource(Result.class)
  void isValid_returnsTrue_ForDocumentCheckResultsThatAreNotNotSet(Result result) {
    check.setDocumentCheckResult(result);

    if (result != NOT_SET) {
      assertThat(validator.isValid(check, null)).isTrue();
    } else {
      assertThat(validator.isValid(check, null)).isFalse();
    }
  }
}
