package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.ErrorCodes;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EconomicOperatorAddress {

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String addressLine1;

  private String addressLine2;
  private String addressLine3;

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String city;

  private String postalZipCode;

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String countryISOCode;

  private String ukTelephone;

  @Valid
  private InternationalTelephone internationalTelephone;

  private String telephone;

  private String email;
}
