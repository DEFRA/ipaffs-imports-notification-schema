package uk.gov.defra.tracesx.notificationschema.representation;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class ControlTest {

  @Test
  void equals() {
    EqualsVerifier.forClass(Control.class)
        .usingGetClass()
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();
  }
}
