package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum;

class PortOfExitAndExitBipNotEmptyValidatorTest {

  private final PortOfExitAndExitBipNotEmptyValidator validator = new PortOfExitAndExitBipNotEmptyValidator();

  @Test
  void validatorShouldReturnTrueIfPartOneIsNull() {
    // Given
    PartOne partOne = null;

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfPurposeIsNull() {
    // Given
    PartOne partOne = new PartOne();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @MethodSource("buildExpectedResults")
  void validatorShouldHandleTestCasesCorrectly(ValidatorTestCase testCase) {
    PartOne partOne = PartOne.builder()
        .portOfExit(testCase.portOfExit)
        .purpose(Purpose.builder()
            .forImportOrAdmission(testCase.forImportOrAdmissionEnum)
            .purposeGroup(testCase.purposeGroup)
            .exitBIP(testCase.exitBip)
            .build())
        .build();

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isEqualTo(testCase.expectedResult);
  }

  private static Stream<Arguments> buildExpectedResults(){
    return Stream.of(
      // Purpose set to Temporary admission horses
      // Both set
      temporaryAdmissionHorses("PORT", "POINT", true),

      //Neither set
      temporaryAdmissionHorses(null, null, false),
      temporaryAdmissionHorses(null,"", false),
      temporaryAdmissionHorses("",null, false),
      temporaryAdmissionHorses("","", false),
  
      // port of exit set but exit bip not set
      temporaryAdmissionHorses("PORT",null, false),
      temporaryAdmissionHorses("PORT","", false),
      temporaryAdmissionHorses("PORT",null, false),
      temporaryAdmissionHorses("PORT","", false),
  
      // port of exit not set but exit bip set
      temporaryAdmissionHorses(null,"POINT", false),
      temporaryAdmissionHorses(null,"POINT", false),
      temporaryAdmissionHorses("","POINT", false),
      temporaryAdmissionHorses("","POINT", false),

      // Purpose set to Transit
      // Both set
      transit("PORT", "POINT", true),

      //Neither set
      transit(null, null, false),
      transit(null,"", false),
      transit("",null, false),
      transit("","", false),

      // port of exit set but exit bip not set
      transit("PORT",null, false),
      transit("PORT","", false),
      transit("PORT",null, false),
      transit("PORT","", false),

      // port of exit not set but exit bip set
      transit(null,"POINT", false),
      transit(null,"POINT", false),
      transit("","POINT", false),
      transit("","POINT", false),
  
      // Purpose set to some other value
      // Both set
      reEntry("PORT","POINT"),
  
      //Neither set
      reEntry(null,null),
      reEntry(null,""),
      reEntry("",null),
      reEntry("",""),
  
      // port of exit set but exit bip not set
      reEntry("PORT",null),
      reEntry("PORT",""),
      reEntry("PORT",null),
      reEntry("PORT",""),
  
      // port of exit not set but exit bip set
      reEntry(null,"POINT"),
      reEntry(null,"POINT"),
      reEntry("","POINT"),
      reEntry("","POINT"),
  
      // Purpose set to null
      new ValidatorTestCase("PORT",null, null,null,true),
      new ValidatorTestCase(null,null,null, null,true)
    ).map(Arguments::of);
  }

  private static ValidatorTestCase temporaryAdmissionHorses(String portOfExit, String exitBip, boolean expectedResult) {
    return new ValidatorTestCase(
        portOfExit,
        exitBip,
        PurposeGroupEnum.RE_IMPORT,
        ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES,
        expectedResult
    );
  }

  private static ValidatorTestCase transit(String portOfExit, String exitBip, boolean expectedResult) {
    return new ValidatorTestCase(
        portOfExit,
        exitBip,
        PurposeGroupEnum.TRANSIT_TO_3RD_COUNTRY,
        null,
        expectedResult
    );
  }

  private static ValidatorTestCase reEntry(String portOfExit, String exitBip) {
    return new ValidatorTestCase(
        portOfExit,
        exitBip,
        PurposeGroupEnum.RE_IMPORT,
        ForImportOrAdmissionEnum.HORSES_RE_ENTRY,
        true
    );
  }

  private record ValidatorTestCase(String portOfExit,
                                   String exitBip,
                                   PurposeGroupEnum purposeGroup,
                                   ForImportOrAdmissionEnum forImportOrAdmissionEnum,
                                   boolean expectedResult) {
  }
}
