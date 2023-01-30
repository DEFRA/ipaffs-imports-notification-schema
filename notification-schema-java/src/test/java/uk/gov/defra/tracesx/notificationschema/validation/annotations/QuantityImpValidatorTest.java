package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ImpQuantityDataKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

@RunWith(MockitoJUnitRunner.class)
public class QuantityImpValidatorTest {

  private List<ComplementParameterSet> complementParameterSets;
  private QuantityImpValidator validator;

  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  ConstraintViolationBuilder constraintViolationBuilderMock;

  @Before
  public void setUp() {
    validator = new QuantityImpValidator();
    complementParameterSets = new ArrayList<>();
    when(constraintValidatorContextMock.unwrap(HibernateConstraintValidatorContext.class))
        .thenReturn(hibernateConstraintValidatorContextMock);

    when(hibernateConstraintValidatorContextMock
        .buildConstraintViolationWithTemplate("Weight must be entered"))
        .thenReturn(constraintViolationBuilderMock);

  }

  @Test
  public void testThatValidatorReturnsTrue_IfNullPassed() {
    assertTrue(validator.isValid(null, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfSets_Empty() {
    complementParameterSets = Collections.emptyList();
    assertTrue(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_ContainsNotExpectedValue() {
    addKeyDataPairValues("unknown", "unknown");
    assertFalse(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_Contains1NullDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_Contains1BlankDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "");
    assertFalse(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_ContainsAnyNullDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "1");
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfSets_ContainsAnyBlankDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "");
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfSets_ContainsCorrectValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "1");
    assertTrue(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfWeight_ContainsAnyNullValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.WEIGHT.getValue(), "");
    addKeyDataPairValues(ImpQuantityDataKeys.WEIGHT.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfKetDataPair_ContainsNullValue() {
    addKeyDataPairValues(null, "");
    addKeyDataPairValues(ImpQuantityDataKeys.WEIGHT.getValue(), null);
    assertFalse(validator.isValid(complementParameterSets, constraintValidatorContextMock));
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
