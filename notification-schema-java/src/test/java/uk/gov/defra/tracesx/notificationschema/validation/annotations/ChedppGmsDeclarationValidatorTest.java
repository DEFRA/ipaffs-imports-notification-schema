package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

@ExtendWith(MockitoExtension.class)
class ChedppGmsDeclarationValidatorTest {

  private Commodities commodities;
  private ChedppGmsDeclarationValidator validator;

  private static final String REGULATORY_AUTHORITY_KEY = "regulatory_authority";
  private static final String MARKETING_STANDARD_KEY = "marketing_standard";
  private static final String HMI = "HMI";
  private static final String JOINT = "JOINT";
  private static final String GMS = "GMS";
  private static final String SMS = "SMS";

  @BeforeEach
  void setup() {
    validator = new ChedppGmsDeclarationValidator();
    commodities = new Commodities();
  }

  @Test
  void validatorShouldReturnTrueIfCommoditiesIsNull() {
    // When
    boolean result = validator.isValid(null, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfComplementParameterSetIsNull() {
    // Given
    Commodities commodities = new Commodities();
    commodities.setComplementParameterSet(null);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnFalseWhenHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsNotSet() {
    // Given
    List<ComplementParameterSet> complementParameterSetList = new ArrayList<>();
    complementParameterSetList.add(createComplementParameterSet(HMI, GMS));
    commodities.setComplementParameterSet(complementParameterSetList);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueWhenHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsTrue() {
    // Given
    List<ComplementParameterSet> complementParameterSetList = new ArrayList<>();
    complementParameterSetList.add(createComplementParameterSet(HMI, GMS));
    commodities.setComplementParameterSet(complementParameterSetList);
    commodities.setGmsDeclarationAccepted(true);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueWhenHmiGmsAndNonHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsTrue() {
    // Given
    List<ComplementParameterSet> complementParameterSetList = new ArrayList<>();
    complementParameterSetList.add(ComplementParameterSet.builder().build());
    complementParameterSetList.add(createComplementParameterSet(HMI, GMS));
    commodities.setComplementParameterSet(complementParameterSetList);
    commodities.setGmsDeclarationAccepted(true);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnFalseWhenHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsFalse() {
    // Given
    List<ComplementParameterSet> complementParameterSetList = new ArrayList<>();
    complementParameterSetList.add(createComplementParameterSet(HMI, GMS));
    commodities.setComplementParameterSet(complementParameterSetList);
    commodities.setGmsDeclarationAccepted(false);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnFalseWhenHmiGmsAndNonHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsFalse() {
    // Given
    List<ComplementParameterSet> complementParameterSetList = new ArrayList<>();
    complementParameterSetList.add(ComplementParameterSet.builder().build());
    complementParameterSetList.add(createComplementParameterSet(HMI, GMS));
    commodities.setComplementParameterSet(complementParameterSetList);
    commodities.setGmsDeclarationAccepted(false);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueWhenNoHmiGmsCommodityIsPresent() {
    // Given
    List<ComplementParameterSet> complementParameterSetList = new ArrayList<>();
    complementParameterSetList.add(createComplementParameterSet(HMI, SMS));
    complementParameterSetList.add(createComplementParameterSet(JOINT, null));
    commodities.setComplementParameterSet(complementParameterSetList);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueWhenAllKeyDataPairDataFieldsAreNull() {
    // Given
    List<ComplementParameterSet> complementParameterSetList = new ArrayList<>();
    complementParameterSetList.add(createComplementParameterSet(null, null));
    commodities.setComplementParameterSet(complementParameterSetList);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  private ComplementParameterSet createComplementParameterSet(String regulatoryAuthority,
      String marketingStandard) {
    List<ComplementParameterSetKeyDataPair> keyDataPairList = new ArrayList<>();

    keyDataPairList.add(ComplementParameterSetKeyDataPair.builder()
        .key(null)
        .data(null)
        .build());

    keyDataPairList.add(ComplementParameterSetKeyDataPair.builder()
        .key(REGULATORY_AUTHORITY_KEY)
        .data(regulatoryAuthority)
        .build());

    if (marketingStandard != null && !marketingStandard.isEmpty()) {
      keyDataPairList.add(ComplementParameterSetKeyDataPair.builder()
          .key(MARKETING_STANDARD_KEY)
          .data(marketingStandard)
          .build());
    }

    return ComplementParameterSet.builder()
        .keyDataPair(keyDataPairList)
        .build();
  }
}
