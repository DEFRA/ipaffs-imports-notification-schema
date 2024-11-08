package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

 class AuthorityTypeTest {
  private final static String EXIT_BIP_STRING = "exitbip";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AuthorityType.EXITBIP.toString();

    assertThat(enumResult).isEqualTo(EXIT_BIP_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AuthorityType.EXITBIP.getValue();

    assertThat(enumResult).isEqualTo(EXIT_BIP_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AuthorityType enumResult = AuthorityType.fromValue(EXIT_BIP_STRING);

    assertThat(enumResult).isEqualTo(AuthorityType.EXITBIP);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AuthorityType enumResult = AuthorityType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
