package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

@ExtendWith(MockitoExtension.class)
class MinValueKeyDataPairValidatorTest {

  @Mock
  private MinValueKeyDataPair mockKeyDataPair;

  private MinValueKeyDataPairValidator validator;
  private List<ComplementParameterSetKeyDataPair> keyDataPairList;

  @BeforeEach
  void setUp() {
    validator = new MinValueKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn("number_package");
    keyDataPairList = new ArrayList<>();
    validator.initialize(mockKeyDataPair);
  }

  @Test
  void testKeyDataPairIsValidIfObjectPassedIsNull() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testNumPackagesIsInvalidIfNoMatchingFieldPresent() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    keyDataPairList.add(pair);
    pair.setKey("number_animal");
    keyDataPairList.add(pair);
    pair.setKey("type_package");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isFalse();
  }

  @Test
  void testNumPackagesIsInvalidIfDataValueCannotBeParsedToInteger() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("X");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isFalse();
  }

  @Test
  void testNumPackagesIsInvalidIfDataValueIsZero() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("0");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isFalse();
  }

  @Test
  void testNumPackagesIsValidIfDataValueIsOne() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("1");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isTrue();
  }

  @Test
  void testNetWeightIsValidIfDataValueIsDecimal() {
    when(mockKeyDataPair.field()).thenReturn("netweight");
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    pair.setData("12.34");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isTrue();
  }

  @Test
  void testNetWeightIsValidIfDataValueIsInteger() {
    when(mockKeyDataPair.field()).thenReturn("netweight");
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    pair.setData("1");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isTrue();
  }
}
