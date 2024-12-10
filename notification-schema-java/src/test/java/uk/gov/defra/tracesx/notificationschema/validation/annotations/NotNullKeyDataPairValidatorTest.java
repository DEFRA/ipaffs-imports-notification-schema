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
class NotNullKeyDataPairValidatorTest {

  @Mock
  private NotNullKeyDataPair mockKeyDataPair;

  private NotNullKeyDataPairValidator validator;
  private List<ComplementParameterSetKeyDataPair> keyDataPairList;

  @BeforeEach
  void setUp() {
    validator = new NotNullKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn("type_package");
    keyDataPairList = new ArrayList<>();
    validator.initialize(mockKeyDataPair);
  }

  @Test
  void testKeyDataPairIsInValidIfObjectPassedIsNull() {
    assertThat(validator.isValid(null, null)).isFalse();
  }

  @Test
  void testTypePackageIsInvalidIfNoMatchingFieldPresent() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    keyDataPairList.add(pair);
    pair.setKey("number_animal");
    keyDataPairList.add(pair);
    pair.setKey("number_package");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isFalse();
  }

  @Test
  void testTypePackageIsInValidIfDataValueIsEmpty() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("type_package");
    pair.setData("");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isFalse();
  }

  @Test
  void testTypePackageIsValidIfDataValueIsNotEmpty() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("type_package");
    pair.setData("bag");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isTrue();
  }
}
