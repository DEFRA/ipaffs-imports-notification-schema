package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class KeyDataPairValidatorTest {

  MinValueKeyDataPairValidator validator;
  MinValueKeyDataPair mockKeyDataPair;
  List<ComplementParameterSetKeyDataPair> keyDataPairList;

  @Before
  public void setUp() {
    validator = new MinValueKeyDataPairValidator();
    mockKeyDataPair = Mockito.mock(MinValueKeyDataPair.class);
    when(mockKeyDataPair.field()).thenReturn("number_package");
    keyDataPairList = new ArrayList();
  }

  @Test
  public void testNumPackagesIsValidIfObjectPassedIsNull() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testNumPackagesIsInvalidIfNoMatchingFieldPresent() {
    validator.initialize(mockKeyDataPair);

    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("key");
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
