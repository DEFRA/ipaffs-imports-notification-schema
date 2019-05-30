package uk.gov.defra.tracesx.notificationschema.representation;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class ControlTest {

  @Test
  public void equals() {
    EqualsVerifier.forClass(Control.class)
        .usingGetClass()
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();
  }
}
