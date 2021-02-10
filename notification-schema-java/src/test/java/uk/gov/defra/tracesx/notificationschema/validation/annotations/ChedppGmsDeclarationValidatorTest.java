package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ChedppGmsDeclarationValidatorTest {

  private Commodities commodities;
  private ChedppGmsDeclarationValidator validator;

  private static final String REGULATORY_AUTHORITY_KEY = "regulatory_authority";
  private static final String MARKETING_STANDARD_KEY = "marketing_standard";
  private static final String HMI = "HMI";
  private static final String JOINT = "JOINT";
  private static final String GMS = "GMS";
  private static final String SMS = "SMS";
  
  @Before
  public void setup() {
    validator = new ChedppGmsDeclarationValidator();
    commodities = new Commodities();
  }

  @Test
  public void validatorShouldReturnTrueIfCommoditiesIsNull() {
    // When
    boolean result = validator.isValid(null, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnTrueIfComplementParameterSetIsNull() {
    // Given
    Commodities commodities = new Commodities();
    commodities.setComplementParameterSet(null);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnFalseWhenHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsNotSet() {
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
  public void validatorShouldReturnTrueWhenHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsTrue() {
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
  public void validatorShouldReturnFalseWhenHmiGmsCommodityIsPresentAndTheGmsDeclarationFlagIsFalse() {
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
  public void validatorShouldReturnTrueWhenNoHmiGmsCommodityIsPresent() {
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
  public void validatorShouldReturnTrueWhenAllKeyDataPairDataFieldsAreNull() {
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
