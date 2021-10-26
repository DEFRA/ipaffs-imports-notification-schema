package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ExternalSystemTest {
  private final static String E_CERT = "E-CERT";
  private final static String E_PHYTO = "E-PHYTO";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void toString_ReturnsECertValue_WhenECertEnum() {
    String enumResult = ExternalSystem.ECERT.toString();
    assertEquals(enumResult, E_CERT);
  }

  @Test
  public void toString_ReturnsEPhytoValue_WhenEPhytoEnum() {
    String enumResult = ExternalSystem.EPHYTO.toString();
    assertEquals(enumResult, E_PHYTO);
  }

  @Test
  public void getValue_ReturnsECertValue_WhenECertEnum() {
    String enumResult = ExternalSystem.ECERT.getValue();
    assertEquals(enumResult, E_CERT);
  }

  @Test
  public void getValue_ReturnsEPhytoValue_WhenEPhytoEnum() {
    String enumResult = ExternalSystem.EPHYTO.getValue();
    assertEquals(enumResult, E_PHYTO);
  }

  @Test
  public void fromValue_ReturnsECertEnum_WhenECertString() {
    ExternalSystem enumResult = ExternalSystem.fromValue(E_CERT);
    assertEquals(enumResult, ExternalSystem.ECERT);
  }

  @Test
  public void fromValue_ReturnsEPhytoEnum_WhenEPhytoString() {
    ExternalSystem enumResult = ExternalSystem.fromValue(E_PHYTO);
    assertEquals(enumResult, ExternalSystem.EPHYTO);
  }

  @Test
  public void fromValue_ReturnsNull_WhenInvalidString() {
    ExternalSystem enumResult = ExternalSystem.fromValue(INVALID_STRING);
    assertNull(enumResult);
  }
}
