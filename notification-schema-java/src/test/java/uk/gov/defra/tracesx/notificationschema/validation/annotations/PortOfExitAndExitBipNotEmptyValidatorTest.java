package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

class PortOfExitAndExitBipNotEmptyValidatorTest {

  private PortOfExitAndExitBipNotEmptyValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new PortOfExitAndExitBipNotEmptyValidator();
    partOne = new PartOne();
  }

  @Test
  void validatorShouldReturnTrueIfPartOneIsNull() {
    // Given
    partOne = null;

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfPurposeIsNull() {
    // Given
    partOne = new PartOne();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @MethodSource("buildExpectedResults")
  void validatorShouldHandleTestCasesCorrectly(ValidatorTestCase testCase) {
    partOne.setPortOfExit(testCase.portOfExit);
    if (testCase.purpose != null) {
      Purpose purpose = Purpose.builder().forImportOrAdmission(testCase.purpose).exitBIP(
          testCase.exitBip).build();
      partOne.setPurpose(purpose);
    }

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isEqualTo(testCase.expectedResult);
  }

  private static Stream<Arguments> buildExpectedResults(){
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

    return list.stream().map(Arguments::of);
  }

  private record ValidatorTestCase(String portOfExit, String exitBip, ForImportOrAdmissionEnum purpose,
                                   boolean expectedResult) {
  }
}
