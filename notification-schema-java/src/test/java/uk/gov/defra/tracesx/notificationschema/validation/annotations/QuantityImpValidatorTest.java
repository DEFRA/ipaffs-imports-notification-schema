package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ImpQuantityDataKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuantityImpValidatorTest {

  private List<ComplementParameterSet> complementParameterSets;
  private QuantityImpValidator validator;

  @Before
  public void setUp() {
    validator = new QuantityImpValidator();
    complementParameterSets = new ArrayList<>();
  }

  @Test
  public void testThatValidatorReturnsTrue_IfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfSets_Empty() {
    complementParameterSets = Collections.emptyList();
    assertTrue(validator.isValid(complementParameterSets, null));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_ContainsNotExpectedValue() {
    addKeyDataPairValues("unknown", "unknown");
    assertFalse(validator.isValid(complementParameterSets, null));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_Contains1NullDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, null));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_Contains1BlankDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "");
    assertFalse(validator.isValid(complementParameterSets, null));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_ContainsAnyNullDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "1");
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, null));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_ContainsAnyBlankDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "");
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, null));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfSets_ContainsCorrectValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "1");
    assertTrue(validator.isValid(complementParameterSets, null));
  }

  private void addKeyDataPairValues(String key, String value) {
    ComplementParameterSetKeyDataPair keyDataPair =
        new ComplementParameterSetKeyDataPair(key, value);

    complementParameterSets.add(ComplementParameterSet.builder()
        .complementID(1123)
        .keyDataPair(Collections.singletonList(keyDataPair))
        .build());
  }
}
