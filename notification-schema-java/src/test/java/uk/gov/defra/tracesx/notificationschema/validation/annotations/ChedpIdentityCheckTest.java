package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.FULL_IDENTITY_CHECK;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;

@RunWith(MockitoJUnitRunner.class)
public class ChedpIdentityCheckTest {

  private ChedpIdentityCheckValidator validator;
  private PartTwo partTwo;

  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  ConstraintViolationBuilder constraintViolationBuilderMock;
  @Mock
  NodeBuilderCustomizableContext nodeBuilderContextMock;

  @Before
  public void setUp() {
    validator = new ChedpIdentityCheckValidator();
    partTwo = new PartTwo();
    when(constraintValidatorContextMock
            .unwrap(HibernateConstraintValidatorContext.class))
            .thenReturn(hibernateConstraintValidatorContextMock);

    when(hibernateConstraintValidatorContextMock
            .buildConstraintViolationWithTemplate(anyString()))
            .thenReturn(constraintViolationBuilderMock);

    when(constraintViolationBuilderMock.addPropertyNode(anyString()))
            .thenReturn(nodeBuilderContextMock);
  }

  @Test
  public void isValid_returnsFalse_whenPartTwoNull() {
    assertFalse(validator.isValid(null, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentCheckNull() {
    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckNullAndIdentityCheckTypeNull() {
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckNullAndIdentityCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNullAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndIdentityCheckTypeNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .build());

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndIdentityCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckSatisfactoryAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckTypeNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }


  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndDecisionNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().build());

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableFalse() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(false).build());

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }
}
