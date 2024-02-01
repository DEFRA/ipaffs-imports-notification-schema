package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@Jacksonized
public class PostalAddress {

  @NotBlank
  private String addressLine1;
  private String addressLine2;
  private String county;
  @NotBlank
  private String cityOrTown;
  @NotBlank
  private String postalCode;
}
