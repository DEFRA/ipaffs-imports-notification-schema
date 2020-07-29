package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RunWith(MockitoJUnitRunner.class)
public class NotNullWoodPackagingKeyDataPairValidatorTest {

  @Mock
  private NotNullWoodPackagingKeyDataPair mockAnnotation;

  private Commodities commodities;
  private NotNullWoodPackagingKeyDataPairValidator validator;

  @Before
  public void setUp() {
    commodities = new Commodities();
    validator = new NotNullWoodPackagingKeyDataPairValidator();
    when(mockAnnotation.field()).thenReturn("units-quantity");
    validator.initialize(mockAnnotation);
  }

  @Test
  public void validatorReturnsTrue_ifNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void validatorReturnsTrue_ifCommodityComplementIsNull() {
    commodities.setCommodityComplement(null);
    commodities.setComplementParameterSet(new ArrayList<>());

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsTrue_ifComplementParameterSetIsNull() {
    commodities.setCommodityComplement(new ArrayList<>());
    commodities.setComplementParameterSet(null);

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsTrue_ifNoCommodities() {
    commodities.setCommodityComplement(new ArrayList<>());
    commodities.setComplementParameterSet(new ArrayList<>());

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsTrue_ifNoWoodPackagingCommodities() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(false)
          .complementID(1)
          .speciesID("1")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsTrue_ifIsWoodPackagingNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifNoMatchingComplementID() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(2)
          .speciesID("1")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifNoMatchingSpeciesID() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(1)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifComplementComplementIDNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(null)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifComplementSpeciesIDNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(1)
          .speciesID(null)
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifComplementComplementIDAndSpeciesIDNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(null)
          .speciesID(null)
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifParameterSetComplementIDNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(1)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(null)
          .speciesID("1")
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifParameterSetSpeciesIDNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(1)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID(null)
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifParameterSetComplementIDAndSpeciesIDNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(1)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(null)
          .speciesID(null)
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifKeyDataPairsNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(1)
          .speciesID("1")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .keyDataPair(null)
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifWoodPackagingCommodityDoesNotHaveField() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(false)
          .complementID(1)
          .speciesID("1")
          .build());
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(2)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
      add(ComplementParameterSet.builder()
          .complementID(2)
          .speciesID("2")
          .keyDataPair(new ArrayList<>() {{
            add(ComplementParameterSetKeyDataPair.builder()
                .key("key")
                .data("data")
                .build());
          }})
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifWoodPackagingCommodityHasFieldButDataNull() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(false)
          .complementID(1)
          .speciesID("1")
          .build());
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(2)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
      add(ComplementParameterSet.builder()
          .complementID(2)
          .speciesID("2")
          .keyDataPair(new ArrayList<>() {{
            add(ComplementParameterSetKeyDataPair.builder()
                .key("units-quantity")
                .data(null)
                .build());
          }})
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalse_ifWoodPackagingCommodityHasFieldButDataEmpty() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(false)
          .complementID(1)
          .speciesID("1")
          .build());
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(2)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
      add(ComplementParameterSet.builder()
          .complementID(2)
          .speciesID("2")
          .keyDataPair(new ArrayList<>() {{
            add(ComplementParameterSetKeyDataPair.builder()
                .key("units-quantity")
                .data("")
                .build());
          }})
          .build());
    }});

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsTrue_ifWoodPackagingCommodityHasFieldAndData() {
    commodities.setCommodityComplement(new ArrayList<>() {{
      add(CommodityComplement.builder()
          .isWoodPackaging(false)
          .complementID(1)
          .speciesID("1")
          .build());
      add(CommodityComplement.builder()
          .isWoodPackaging(true)
          .complementID(2)
          .speciesID("2")
          .build());
    }});
    commodities.setComplementParameterSet(new ArrayList<>() {{
      add(ComplementParameterSet.builder()
          .complementID(1)
          .speciesID("1")
          .build());
      add(ComplementParameterSet.builder()
          .complementID(2)
          .speciesID("2")
          .keyDataPair(new ArrayList<>() {{
            add(ComplementParameterSetKeyDataPair.builder()
                .key("units-quantity")
                .data("Data")
                .build());
          }})
          .build());
    }});

    assertTrue(validator.isValid(commodities, null));
  }
}
