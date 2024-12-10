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

class PortOfEntryAndPointOfEntryNotEmptyValidatorTest {

  private PortOfEntryAndPointOfEntryNotEmptyValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new PortOfEntryAndPointOfEntryNotEmptyValidator();
    partOne = new PartOne();
  }

  @Test
  void validatorShouldReturnFalseIfPartOneIsNull() {
    // Given
    partOne = null;

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @MethodSource("buildExpectedResults")
  void validatorShouldHandleTestCasesCorrectly(ValidatorTestCase testCase) {
    partOne.setPointOfEntry(testCase.pointOfEntry);
    partOne.setPortOfEntry(testCase.portOfEntry);
    boolean result = validator.isValid(partOne, null);

    assertThat(result).isEqualTo(testCase.expectedResult);
  }

  private static Stream<Arguments> buildExpectedResults() {
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
    return list.stream().map(Arguments::of);
  }

  private record ValidatorTestCase(String portOfEntry, String pointOfEntry,
                                   boolean expectedResult) {

  }
}
