package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@Jacksonized
public class BillingInformation {

  @NotBlank
  private String emailAddress;

  @NotBlank
  private String phoneNumber;

  @Valid
  private PostalAddress postalAddress;
}
