package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MinValueKeyDataPairValidatorTest {

  @Mock
  private MinValueKeyDataPair mockKeyDataPair;

  private MinValueKeyDataPairValidator validator;
  private List<ComplementParameterSetKeyDataPair> keyDataPairList;

  @Before
  public void setUp() {
    validator = new MinValueKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn("number_package");
    keyDataPairList = new ArrayList<>();
  }

  @Test
  public void testKeyDataPairIsValidIfObjectPassedIsNull() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testNumPackagesIsInvalidIfNoMatchingFieldPresent() {
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    keyDataPairList.add(pair);
    pair.setKey("number_animal");
    keyDataPairList.add(pair);
    pair.setKey("type_package");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNumPackagesIsInvalidIfDataValueCannotBeParsedToInteger() {
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("X");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNumPackagesIsInvalidIfDataValueIsZero() {
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("0");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNumPackagesIsValidIfDataValueIsOne() {
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("1");
    keyDataPairList.add(pair);

    assertTrue(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNetWeightIsValidIfDataValueIsDecimal() {
    when(mockKeyDataPair.field()).thenReturn("netweight");
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    pair.setData("12.34");
    keyDataPairList.add(pair);

    assertTrue(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNetWeightIsValidIfDataValueIsInteger() {
    when(mockKeyDataPair.field()).thenReturn("netweight");
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    pair.setData("1");
    keyDataPairList.add(pair);

    assertTrue(validator.isValid(keyDataPairList, null));
  }
}
