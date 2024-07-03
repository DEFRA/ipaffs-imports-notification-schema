package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.ErrorCodes;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EconomicOperatorAddress {

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  @RetrospectiveCloningProperty()
  private String addressLine1;

  @RetrospectiveCloningProperty()
  private String addressLine2;

  @RetrospectiveCloningProperty()
  private String addressLine3;

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  @RetrospectiveCloningProperty()
  private String city;

  @RetrospectiveCloningProperty()
  private String postalZipCode;

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  @RetrospectiveCloningProperty()
  private String countryISOCode;

  private String ukTelephone;

  @Valid
  private InternationalTelephone internationalTelephone;

  @RetrospectiveCloningProperty()
  private String telephone;

  @RetrospectiveCloningProperty()
  private String email;
}
