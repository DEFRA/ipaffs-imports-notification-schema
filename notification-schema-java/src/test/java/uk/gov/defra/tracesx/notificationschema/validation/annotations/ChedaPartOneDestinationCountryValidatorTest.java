package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum;

@ExtendWith(MockitoExtension.class)
class ChedaPartOneDestinationCountryValidatorTest {

  private final ChedaPartOneDestinationCountryValidator validator = new ChedaPartOneDestinationCountryValidator();


  @Test
  void isValid_ReturnsTrueIfPurposeIsNull() {
    var partOne = PartOne.builder().purpose(null).build();

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @ParameterizedTest
  @MethodSource("allChedAPurposes")
  void isValid_ReturnsTrueIfThirdCountryIsPopulated(PartOne partOne) {
    partOne.getPurpose().setThirdCountry("A value");

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  private static Stream<Arguments> allChedAPurposes() {
    return Stream.of(
        internalMarket(),
        transhipment(),
        transit(),
        reEntry(),
        temporaryAdmissionHorses()
    ).map(Arguments::of);
  }

  @Test
  void isValid_ReturnsTrueIfThirdCountryNotProvided_ForInternalMarket() {
    var partOne = internalMarket();
    partOne.getPurpose().setThirdCountry(null);

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrueIfThirdCountryNotProvided_ForTranshipment() {
    var partOne = transhipment();
    partOne.getPurpose().setThirdCountry(null);

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @Test
  void isValid_ReturnsFalseIfThirdCountryNotProvided_ForTransit() {
    var partOne = transit();
    partOne.getPurpose().setThirdCountry(null);

    assertThat(validator.isValid(partOne, null)).isFalse();
  }

  @Test
  void isValid_ReturnsTrueIfThirdCountryNotProvided_ForReEntry() {
    var partOne = reEntry();
    partOne.getPurpose().setThirdCountry(null);

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrueIfThirdCountryNotProvided_ForTemporaryAdmissionHorses() {
    var partOne = temporaryAdmissionHorses();
    partOne.getPurpose().setThirdCountry(null);

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  private static PartOne internalMarket() {
    return PartOne.builder()
        .purpose(Purpose.builder()
            .forImportOrAdmission(ForImportOrAdmissionEnum.DEFINITIVE_IMPORT)
            .purposeGroup(PurposeGroupEnum.RE_IMPORT)
            .build())
        .build();
  }

  private static PartOne transhipment() {
    return PartOne.builder()
        .purpose(Purpose.builder()
            .purposeGroup(PurposeGroupEnum.TRANSHIPMENT_TO)
            .build())
        .build();
  }

  private static PartOne transit() {
    return PartOne.builder()
        .purpose(Purpose.builder()
            .purposeGroup(PurposeGroupEnum.TRANSIT_TO_3RD_COUNTRY)
            .build())
        .build();
  }

  private static PartOne reEntry() {
    return PartOne.builder()
        .purpose(Purpose.builder()
            .forImportOrAdmission(ForImportOrAdmissionEnum.HORSES_RE_ENTRY)
            .purposeGroup(PurposeGroupEnum.RE_IMPORT)
            .build())
        .build();
  }

  private static PartOne temporaryAdmissionHorses() {
    return PartOne.builder()
        .purpose(Purpose.builder()
            .forImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES)
            .purposeGroup(PurposeGroupEnum.RE_IMPORT)
            .build())
        .build();
  }
}
