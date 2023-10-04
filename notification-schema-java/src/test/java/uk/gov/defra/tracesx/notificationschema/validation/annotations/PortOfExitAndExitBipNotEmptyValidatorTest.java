package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

@RunWith(MockitoJUnitRunner.class)
public class PortOfExitAndExitBipNotEmptyValidatorTest {

  private PortOfExitAndExitBipNotEmptyValidator validator;

  private PartOne partOne;

  @Before
  public void setUp() {
    validator = new PortOfExitAndExitBipNotEmptyValidator();
    partOne = new PartOne();
  }

  @Test
  public void validatorShouldReturnTrueIfPartOneIsNull() {
    // Given
    partOne = null;

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnTrueIfPurposeIsNull() {
    // Given
    partOne = new PartOne();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldHandleTestCasesCorrectly() {
    ArrayList<ValidatorTestCase> expectedResultTestCases = buildExpectedResults();
    for (ValidatorTestCase nextExpectedResult: expectedResultTestCases) {
      runAndCheckValidation(nextExpectedResult);
    }
  }

  private void runAndCheckValidation(ValidatorTestCase validatorTestCase){
    partOne.setPortOfExit(validatorTestCase.portOfExit);
    if (validatorTestCase.purpose != null) {
      Purpose purpose = Purpose.builder().forImportOrAdmission(validatorTestCase.purpose).exitBIP(
          validatorTestCase.exitBip).build();
      partOne.setPurpose(purpose);
    }


    boolean result = validator.isValid(partOne, null);

    assertEquals(validatorTestCase.expectedResult, result);
  }

  private ArrayList<ValidatorTestCase> buildExpectedResults(){
    ArrayList<ValidatorTestCase> list = new ArrayList<>();

    // Purpose set to Temporary admission horses
    // Both set
    list.add(new ValidatorTestCase("PORT","POINT",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,true));

    //Neither set
    list.add(new ValidatorTestCase(null,null,ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase(null,"",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase("",null,ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase("","",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));

    // port of exit set but exit bip not set
    list.add(new ValidatorTestCase("PORT",null,ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase("PORT","",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase("PORT",null,ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase("PORT","",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));

    // port of exit not set but exit bip set
    list.add(new ValidatorTestCase(null,"POINT",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase(null,"POINT",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase("","POINT",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));
    list.add(new ValidatorTestCase("","POINT",ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,false));

    // Purpose set to something other than Temporary admission horses
    // Both set
    list.add(new ValidatorTestCase("PORT","POINT",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));

    //Neither set
    list.add(new ValidatorTestCase(null,null,ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase(null,"",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase("",null,ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase("","",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));

    // port of exit set but exit bip not set
    list.add(new ValidatorTestCase("PORT",null,ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase("PORT","",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase("PORT",null,ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase("PORT","",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));

    // port of exit not set but exit bip set
    list.add(new ValidatorTestCase(null,"POINT",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase(null,"POINT",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase("","POINT",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));
    list.add(new ValidatorTestCase("","POINT",ForImportOrAdmissionEnum.HORSES_RE_ENTRY,true));

    // Purpose set to null
    list.add(new ValidatorTestCase("PORT",null,null,true));
    list.add(new ValidatorTestCase(null,null,null,true));

    return list;
  }

  private static class ValidatorTestCase {
    public String portOfExit;
    public String exitBip;
    public boolean expectedResult;
    ForImportOrAdmissionEnum purpose;

    public ValidatorTestCase(String portOfExit, String exitBip, ForImportOrAdmissionEnum purpose, boolean expectedResult){
      this.exitBip = exitBip;
      this.portOfExit = portOfExit;
      this.expectedResult = expectedResult;
      this.purpose = purpose;
    }
  }
}