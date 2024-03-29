package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ExternalReference {

  private ExternalSystem system;
  private String reference;
  private Boolean exactMatch;
  private Boolean verifiedByImporter;
  private Boolean verifiedByInspector;

  public ExternalReference(ExternalSystem system, String reference) {
    this.system = system;
    this.reference = reference;
  }
}
