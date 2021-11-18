package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.LOW_RISK_ARTICLE_72_COMMODITY;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ChedppPodRequiredValidatorTest {

  private ChedppPodRequiredValidator validator;
  private PartOne partOne;
  private EconomicOperator pod;

  private static final String VIA_TEMPORARY_PLACE_OF_DESTINATION = "POD";

  @Before
  public void setup() {
    validator = new ChedppPodRequiredValidator();
    partOne = new PartOne();
    pod = new EconomicOperator();
  }

  @Test
  public void validatorShouldReturnTrueIfPartOneIsNull() {
    // When
    boolean result = validator.isValid(null, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnTrueIfInspectionPremiseIsNull() {
    // Given
    partOne.setPointOfEntryControlPoint(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnFalseIfPodIsNullAndInspectionPremiseSetToPod() {
    // Given
    partOne.setPointOfEntryControlPoint(VIA_TEMPORARY_PLACE_OF_DESTINATION);
    partOne.setPod(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  public void validatorShouldReturnTrueIfPodIsSetAndInspectionPremiseSetToPod() {
    // Given
    partOne.setPointOfEntryControlPoint(VIA_TEMPORARY_PLACE_OF_DESTINATION);
    partOne.setPod(pod);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnTrueIfPodIsSetAndInspectionPremiseIsNotSetToPod() {
    // Given
    partOne.setPointOfEntryControlPoint("Some Random Place");
    partOne.setPod(pod);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void isValid_ReturnsTrue_WhenConsignmentIsArticle72() {
    partOne.setCommodities(Commodities.builder()
        .isLowRiskArticle72Country(true)
        .complementParameterSet(List.of(
            ComplementParameterSet.builder()
                .keyDataPair(List.of(
                    ComplementParameterSetKeyDataPair.builder()
                        .key(LOW_RISK_ARTICLE_72_COMMODITY)
                        .data(TRUE.toString())
                        .build()
                )).build()
        )).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  public void isValid_ReturnsFalse_WhenConsignmentIsNotArticle72() {
    partOne.setPointOfEntryControlPoint(VIA_TEMPORARY_PLACE_OF_DESTINATION);
    partOne.setCommodities(Commodities.builder()
        .isLowRiskArticle72Country(false)
        .build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }
}