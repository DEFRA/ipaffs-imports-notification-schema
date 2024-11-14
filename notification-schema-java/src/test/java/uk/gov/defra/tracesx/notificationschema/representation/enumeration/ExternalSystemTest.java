package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExternalSystemTest {
  private final static String E_CERT = "E-CERT";
  private final static String E_PHYTO = "E-PHYTO";
  private final static String INVALID_STRING = "Invalid";
  private final static String NCTS = "NCTS";

  @Test
  void toString_ReturnsECertValue_WhenECertEnum() {
    String enumResult = ExternalSystem.ECERT.toString();
    assertThat(enumResult).isEqualTo(E_CERT);
  }

  @Test
  void toString_ReturnsEPhytoValue_WhenEPhytoEnum() {
    String enumResult = ExternalSystem.EPHYTO.toString();
    assertThat(enumResult).isEqualTo(E_PHYTO);
  }

  @Test
  void toString_ReturnsNCTSValue_WhenNCTS() {
    String enumResult = ExternalSystem.NCTS.toString();
    assertThat(enumResult).isEqualTo(NCTS);
  }

  @Test
  void getValue_ReturnsECertValue_WhenECertEnum() {
    String enumResult = ExternalSystem.ECERT.getValue();
    assertThat(enumResult).isEqualTo(E_CERT);
  }

  @Test
  void getValue_ReturnsEPhytoValue_WhenEPhytoEnum() {
    String enumResult = ExternalSystem.EPHYTO.getValue();
    assertThat(enumResult).isEqualTo(E_PHYTO);
  }

  @Test
  void getValue_ReturnsNCTSValue_WhenNCTS() {
    String enumResult = ExternalSystem.NCTS.getValue();
    assertThat(enumResult).isEqualTo(NCTS);
  }

  @Test
  void fromValue_ReturnsECertEnum_WhenECertString() {
    ExternalSystem enumResult = ExternalSystem.fromValue(E_CERT);
    assertThat(enumResult).isEqualTo(ExternalSystem.ECERT);
  }

  @Test
  void fromValue_ReturnsEPhytoEnum_WhenEPhytoString() {
    ExternalSystem enumResult = ExternalSystem.fromValue(E_PHYTO);
    assertThat(enumResult).isEqualTo(ExternalSystem.EPHYTO);
  }

  @Test
  void fromValue_ReturnsNCTSEnum_WhenNCTSString() {
    ExternalSystem enumResult = ExternalSystem.fromValue(NCTS);
    assertThat(enumResult).isEqualTo(ExternalSystem.NCTS);
  }

  @Test
  void fromValue_ReturnsNull_WhenInvalidString() {
    ExternalSystem enumResult = ExternalSystem.fromValue(INVALID_STRING);
    assertThat(enumResult).isNull();
  }
}
