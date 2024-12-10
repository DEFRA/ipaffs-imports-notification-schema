package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintViolationBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ImpQuantityDataKeys;

@ExtendWith(MockitoExtension.class)
class QuantityImpValidatorTest {

  private List<ComplementParameterSet> complementParameterSets;
  private QuantityImpValidator validator;

  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  HibernateConstraintViolationBuilder hibernateConstraintViolationBuilder;

  @BeforeEach
  void setUp() {
    validator = new QuantityImpValidator();
    complementParameterSets = new ArrayList<>();

  }

  void validatorMocking() {
    when(constraintValidatorContextMock.unwrap(HibernateConstraintValidatorContext.class))
        .thenReturn(hibernateConstraintValidatorContextMock);

    when(hibernateConstraintValidatorContextMock
        .buildConstraintViolationWithTemplate("Weight must be entered"))
        .thenReturn(hibernateConstraintViolationBuilder);
  }

  @Test
  void testThatValidatorReturnsTrue_IfNullPassed() {
    assertThat(validator.isValid(null, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrue_IfSets_Empty() {
    complementParameterSets = Collections.emptyList();
    assertThat(validator.isValid(complementParameterSets, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void testThatValidatorReturnsFalse_IfSets_ContainsNotExpectedValue() {
    addKeyDataPairValues("unknown", "unknown");
    assertThat(
        validator.isValid(complementParameterSets, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void testThatValidatorReturnsFalse_IfSets_Contains1NullDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertThat(
        validator.isValid(complementParameterSets, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void testThatValidatorReturnsFalse_IfSets_Contains1BlankDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "");
    assertThat(
        validator.isValid(complementParameterSets, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void testThatValidatorReturnsFalse_IfSets_ContainsAnyNullDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "1");
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertThat(
        validator.isValid(complementParameterSets, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void testThatValidatorReturnsFalse_IfSets_ContainsAnyBlankDataValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "");
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), null);
    assertThat(
        validator.isValid(complementParameterSets, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void testThatValidatorReturnsTrue_IfSets_ContainsCorrectValue() {
    addKeyDataPairValues(ImpQuantityDataKeys.ANIMALS.getValue(), "1");
    assertThat(validator.isValid(complementParameterSets, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void testThatValidatorReturnsFalse_IfWeight_ContainsAnyNullValue() {
    validatorMocking();
    addKeyDataPairValues(ImpQuantityDataKeys.WEIGHT.getValue(), "");
    addKeyDataPairValues(ImpQuantityDataKeys.WEIGHT.getValue(), null);
    assertThat(
        validator.isValid(complementParameterSets, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void testThatValidatorReturnsFalse_IfKetDataPair_ContainsNullValue() {
    addKeyDataPairValues(null, "");
    addKeyDataPairValues(ImpQuantityDataKeys.WEIGHT.getValue(), null);
    assertThat(
        validator.isValid(complementParameterSets, constraintValidatorContextMock)).isFalse();
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
