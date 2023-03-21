package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

@RunWith(MockitoJUnitRunner.class)
public class IsNonNegativeIntegerKeyDataPairValidatorTest {

  @Mock
  private IsNonNegativeIntegerKeyDataPair mockKeyDataPair;

  private IsNonNegativeIntegerKeyDataPairValidator validator;
  private List<ComplementParameterSetKeyDataPair> keyDataPairList;

  @Before
  public void setUp() {
    validator = new IsNonNegativeIntegerKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn("number_package");
    keyDataPairList = new ArrayList<>();
    validator.initialize(mockKeyDataPair);
  }

  @Test
  public void testKeyDataPairIsInValidIfObjectPassedIsNull() {
    assertFalse(validator.isValid(null, null));
  }

  @Test
  public void testNumberPackageValidationFailsIfNoValueIsProvided() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNumberPackageValidationPassesWithValidInteger() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("1");
    keyDataPairList.add(pair);

    assertTrue(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNumberPackageValidationFailsWithNegativeInteger() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("-1");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNumberPackageValidationFailsWithNonIntegerType() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("oiiwr");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testNumberPackageValidationFailsIfValueIsOutsideOfIntegerRange() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("332840984904824029348904820");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }
}
