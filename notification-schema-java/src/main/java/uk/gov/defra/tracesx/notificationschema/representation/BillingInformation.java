package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@Jacksonized
public class BillingInformation {

  @NotBlank
  private Boolean isConfirmed;

  @NotBlank
  private String emailAddress;

  @NotBlank
  private String phoneNumber;

  @NotBlank
  private String contactName;

  @Valid
  private PostalAddress postalAddress;
}
