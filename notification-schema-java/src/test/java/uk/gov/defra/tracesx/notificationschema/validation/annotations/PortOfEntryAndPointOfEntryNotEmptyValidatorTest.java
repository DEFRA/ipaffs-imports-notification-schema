package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@RunWith(MockitoJUnitRunner.class)
public class PortOfEntryAndPointOfEntryNotEmptyValidatorTest {

  private PortOfEntryAndPointOfEntryNotEmptyValidator validator;

  private PartOne partOne;

  @Before
  public void setUp() {
    validator = new PortOfEntryAndPointOfEntryNotEmptyValidator();
    partOne = new PartOne();
  }

  @Test
  public void validatorShouldReturnFalseIfPartOneIsNull() {
    // Given
    partOne = null;

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldHandleTestCasesCorrectly() {
    ArrayList<ValidatorTestCase> expectedResultTestCases = buildExpectedResults();
    for (ValidatorTestCase nextExpectedResult: expectedResultTestCases) {
      runAndCheckValidation(nextExpectedResult);
    }
  }

  private void runAndCheckValidation(ValidatorTestCase validatorTestCase){
    partOne.setPointOfEntry(validatorTestCase.pointOfEntry);
    partOne.setPortOfEntry(validatorTestCase.portOfEntry);
    boolean result = validator.isValid(partOne, null);

    assertEquals(validatorTestCase.expectedResult, result);
  }

  private ArrayList<ValidatorTestCase> buildExpectedResults(){
    ArrayList<ValidatorTestCase> list = new ArrayList<>();
    // Both set
    list.add(new ValidatorTestCase("PORT","POINT",true));

    //Neither set
    list.add(new ValidatorTestCase(null,null,false));
    list.add(new ValidatorTestCase(null,"",false));
    list.add(new ValidatorTestCase("",null,false));
    list.add(new ValidatorTestCase("","",false));

    // port of entry set but point of entry not set
    list.add(new ValidatorTestCase("PORT",null,false));
    list.add(new ValidatorTestCase("PORT","",false));
    list.add(new ValidatorTestCase("PORT",null,false));
    list.add(new ValidatorTestCase("PORT","",false));

    // port of entry not set but point of entry set
    list.add(new ValidatorTestCase(null,"POINT",false));
    list.add(new ValidatorTestCase(null,"POINT",false));
    list.add(new ValidatorTestCase("","POINT",false));
    list.add(new ValidatorTestCase("","POINT",false));
    return list;
  }

  private static class ValidatorTestCase {
    public String portOfEntry;
    public String pointOfEntry;
    public boolean expectedResult;

    public ValidatorTestCase(String portOfEntry, String pointOfEntry, boolean expectedResult){
      this.pointOfEntry = pointOfEntry;
      this.portOfEntry = portOfEntry;
      this.expectedResult = expectedResult;
    }
  }
}