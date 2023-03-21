package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.ErrorCodes;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class InternationalTelephone {

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message = ErrorCodes.NOT_NULL)
  private String countryCode;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message = ErrorCodes.NOT_NULL)
  private String subscriberNumber;
}
