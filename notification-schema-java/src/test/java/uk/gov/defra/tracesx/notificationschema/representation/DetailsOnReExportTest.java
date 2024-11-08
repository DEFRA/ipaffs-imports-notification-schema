package uk.gov.defra.tracesx.notificationschema.representation;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class DetailsOnReExportTest {

  @Test
  void equals() {
    EqualsVerifier.forClass(DetailsOnReExport.class)
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();
  }
}
