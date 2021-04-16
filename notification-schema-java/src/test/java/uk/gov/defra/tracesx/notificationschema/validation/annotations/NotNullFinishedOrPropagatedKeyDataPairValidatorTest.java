package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.Arrays;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class NotNullFinishedOrPropagatedKeyDataPairValidatorTest {

  private Commodities commodities;
  private NotNullFinishedOrPropagatedKeyDataPairValidator validator;

  private static final String COMMODITY_GROUP_KEY = "commodity_group";
  private static final String FINISHED_OR_PROPAGATED_KEY = "finished_or_propagated";
  private static final String PLANTS_FOR_PLANTING = "Plants for Planting";
  private static final String VEGETABLES = "Vegetables";
  private static final String FINISHED = "finished";

  @Before
  public void setup() {
    validator = new NotNullFinishedOrPropagatedKeyDataPairValidator();
    commodities = new Commodities();
    commodities.setComplementParameterSet(Collections.emptyList());
  }

  @Test
  public void validationShouldPassIfCommoditiesIsNull() {
    // When
    boolean result = validator.isValid(null, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldPassIfComplementParameterSetIsNull() {
    // Given
    commodities.setComplementParameterSet(null);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldPassIfChargeGroupFlagIsNull() {
    // Given
    commodities.setConsignedCountryInChargeGroup(null);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldPassIfChargeGroupFlagIsFalse() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.FALSE);

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldPassIfKeyDataPairIsNull() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.TRUE);
    commodities.setComplementParameterSet(Collections.singletonList(
        ComplementParameterSet.builder().build()));

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldFailIfApplicableCommodityGroupAndFinishedOrPropagatedKeyDataPairIsNotSet() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.TRUE);
    commodities.setComplementParameterSet(Collections.singletonList(
        ComplementParameterSet.builder()
            .keyDataPair(
                Arrays.asList(
                    ComplementParameterSetKeyDataPair.builder()
                        .key(null)
                        .data(null)
                        .build(),
                    ComplementParameterSetKeyDataPair.builder()
                        .key(COMMODITY_GROUP_KEY)
                        .data(PLANTS_FOR_PLANTING)
                        .build())
            ).build()));

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  public void validationShouldPassIfCommodityGroupKeyDataPairDataIsMissing() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.TRUE);
    commodities.setComplementParameterSet(Collections.singletonList(
        ComplementParameterSet.builder()
            .keyDataPair(
                Arrays.asList(
                    ComplementParameterSetKeyDataPair.builder()
                        .key(null)
                        .data(null)
                        .build(),
                    ComplementParameterSetKeyDataPair.builder()
                        .key(COMMODITY_GROUP_KEY)
                        .build())
            ).build()));

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldPassIfCommodityGroupIsNotInTheKeyDataPair() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.TRUE);
    commodities.setComplementParameterSet(Collections.singletonList(
        ComplementParameterSet.builder()
            .keyDataPair(
                Collections.singletonList(
                    ComplementParameterSetKeyDataPair.builder()
                        .key(null)
                        .data(null)
                        .build())
            ).build()));

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldFailIfFinishedOrPropagatedKeyDataPairDataIsMissing() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.TRUE);
    commodities.setComplementParameterSet(Collections.singletonList(
        ComplementParameterSet.builder()
            .keyDataPair(
                Arrays.asList(
                    ComplementParameterSetKeyDataPair.builder()
                        .key(null)
                        .data(null)
                        .build(),
                    ComplementParameterSetKeyDataPair.builder()
                        .key(COMMODITY_GROUP_KEY)
                        .data(PLANTS_FOR_PLANTING)
                        .build(),
                    ComplementParameterSetKeyDataPair.builder()
                        .key(FINISHED_OR_PROPAGATED_KEY)
                        .build())
            ).build()));

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  public void validationShouldPassIfNotApplicableCommodityGroupAndFinishedOrPropagatedKeyDataPairIsNotSet() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.TRUE);
    commodities.setComplementParameterSet(Collections.singletonList(
        ComplementParameterSet.builder()
            .keyDataPair(
                Arrays.asList(
                    ComplementParameterSetKeyDataPair.builder()
                        .key(null)
                        .data(null)
                        .build(),
                    ComplementParameterSetKeyDataPair.builder()
                        .key(COMMODITY_GROUP_KEY)
                        .data(VEGETABLES)
                        .build())
            ).build()));

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validationShouldPassIfFinishedOrPropagatedKeyDataPairIsSet() {
    // Given
    commodities.setConsignedCountryInChargeGroup(Boolean.TRUE);
    commodities.setComplementParameterSet(Collections.singletonList(
        ComplementParameterSet.builder()
            .keyDataPair(
                Arrays.asList(
                    ComplementParameterSetKeyDataPair.builder()
                        .key(null)
                        .data(null)
                        .build(),
                    ComplementParameterSetKeyDataPair.builder()
                        .key(COMMODITY_GROUP_KEY)
                        .data(PLANTS_FOR_PLANTING)
                        .build(),
                    ComplementParameterSetKeyDataPair.builder()
                        .key(FINISHED_OR_PROPAGATED_KEY)
                        .data(FINISHED)
                        .build()
                )).build()));

    // When
    boolean result = validator.isValid(commodities, null);

    // Then
    assertThat(result).isTrue();
  }
}
