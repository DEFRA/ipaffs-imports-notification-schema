package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ExternalReference {

  @RetrospectiveCloningProperty()
  private ExternalSystem system;
  @RetrospectiveCloningProperty()
  private String reference;
  @RetrospectiveCloningProperty()
  private Boolean exactMatch;
  @RetrospectiveCloningProperty()
  private Boolean verifiedByImporter;
  @RetrospectiveCloningProperty()
  private Boolean verifiedByInspector;

  public ExternalReference(ExternalSystem system, String reference) {
    this.system = system;
    this.reference = reference;
  }
}
