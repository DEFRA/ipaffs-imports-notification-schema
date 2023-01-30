package uk.gov.defra.tracesx.notificationschema.representation;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class FeedbackInformationTest {

  @Test
  public void equals() {
    EqualsVerifier.forClass(FeedbackInformation.class)
        .usingGetClass()
        .suppress(Warning.NONFINAL_FIELDS)
        .suppress(Warning.ANNOTATION)
        .verify();
  }
}
