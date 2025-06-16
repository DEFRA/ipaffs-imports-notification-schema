package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PhsiClassificationTest {

  private static final String MANDATORY_STRING = "Mandatory";
  private static final String REDUCED_STRING = "Reduced";
  private static final String CONTROLLED_STRING = "Controlled";
  private static final String NOT_NOTIFIABLE_STRING = "NotNotifiable";
  private static final String INVALID_STRING = "Invalid";

  private static Stream<Arguments> enumStringMatches() {
    return Stream.of(
        Arguments.of(PhsiClassification.MANDATORY, MANDATORY_STRING),
        Arguments.of(PhsiClassification.REDUCED, REDUCED_STRING),
        Arguments.of(PhsiClassification.CONTROLLED, CONTROLLED_STRING),
        Arguments.of(PhsiClassification.NOT_NOTIFIABLE, NOT_NOTIFIABLE_STRING)
    );
  }

  @ParameterizedTest
  @MethodSource("enumStringMatches")
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue(PhsiClassification classification, String expected) {
    String enumResult = classification.toString();
    assertThat(enumResult).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("enumStringMatches")
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue(PhsiClassification classification, String expected) {
    String enumResult = classification.getValue();
    assertThat(enumResult).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("enumStringMatches")
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue(PhsiClassification classification, String expected) {
    PhsiClassification enumResult = PhsiClassification.fromValue(expected);
    assertThat(enumResult).isEqualTo(classification);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PhsiDecision enumResult = PhsiDecision.fromValue(INVALID_STRING);
    assertThat(enumResult).isNull();
  }
}
