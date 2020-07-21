package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
public class NotNullKeyDataPairValidatorTest {

  @Mock
  private NotNullKeyDataPair mockKeyDataPair;

  private NotNullKeyDataPairValidator validator;
  private List<ComplementParameterSetKeyDataPair> keyDataPairList;

  @Before
  public void setUp() {
    validator = new NotNullKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn("type_package");
    keyDataPairList = new ArrayList<>();
    validator.initialize(mockKeyDataPair);
  }

  @Test
  public void testKeyDataPairIsInValidIfObjectPassedIsNull() {
    assertFalse(validator.isValid(null, null));
  }

  @Test
  public void testTypePackageIsInvalidIfNoMatchingFieldPresent() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("netweight");
    keyDataPairList.add(pair);
    pair.setKey("number_animal");
    keyDataPairList.add(pair);
    pair.setKey("number_package");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testTypePackageIsInValidIfDataValueIsEmpty() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("type_package");
    pair.setData("");
    keyDataPairList.add(pair);

    assertFalse(validator.isValid(keyDataPairList, null));
  }

  @Test
  public void testTypePackageIsValidIfDataValueIsNotEmpty() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("type_package");
    pair.setData("bag");
    keyDataPairList.add(pair);

    assertTrue(validator.isValid(keyDataPairList, null));
  }
}
