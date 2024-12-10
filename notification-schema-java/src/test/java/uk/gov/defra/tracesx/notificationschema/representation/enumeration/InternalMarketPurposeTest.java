package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InternalMarketPurposeTest {
  private final static String OTHER_STRING = "Other";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.OTHER.toString()).hasToString(OTHER_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    assertThat(InternalMarketPurpose.OTHER.getValue()).isEqualTo(OTHER_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    assertThat(InternalMarketPurpose.fromValue(OTHER_STRING)).isEqualTo(InternalMarketPurpose.OTHER);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    assertThat(InternalMarketPurpose.fromValue(INVALID_STRING)).isNull();
  }

  @Test
  void givenCommercialSale_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.COMMERCIAL_SALE.toString()).hasToString(
            "Commercial Sale");
  }

  @Test
  void givenCommercialSaleOrChangeOfOwnership_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.COMMERCIAL_SALE_OR_CHANGE_OF_OWNERSHIP.toString()).hasToString(
            "Commercial sale or change of ownership");
  }

  @Test
  void givenRescue_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.RESCUE.toString()).hasToString("Rescue");
  }

  @Test
  void givenBreeding_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.BREEDING.toString()).hasToString("Breeding");
  }

  @Test
  void givenResearch_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.RESEARCH.toString()).hasToString("Research");
  }

  @Test
  void givenRacing_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.RACING.toString()).hasToString("Racing or Competition");
  }

  @Test
  void givenPremises_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.APPROVED_PREMISES.toString()).hasToString("Approved Premises or Body");
  }

  @Test
  void givenCompanion_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.COMPANION_ANIMAL.toString()).hasToString("Companion Animal not for Resale or Rehoming");
  }

  @Test
  void givenProduction_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.PRODUCTION.toString()).hasToString("Production");
  }

  @Test
  void givenSlaughter_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.SLAUGHTER.toString()).hasToString("Slaughter");
  }

  @Test
  void givenFattening_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.FATTENING.toString()).hasToString("Fattening");
  }

  @Test
  void givenRestocking_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.GAME_RESTOCKING.toString()).hasToString("Game Restocking");
  }

  @Test
  void givenHorses_whenToStringCalled_shouldReturnStringValue() {
    assertThat(InternalMarketPurpose.REGISTERED_HORSES.toString()).hasToString("Registered Horses");
  }
}
