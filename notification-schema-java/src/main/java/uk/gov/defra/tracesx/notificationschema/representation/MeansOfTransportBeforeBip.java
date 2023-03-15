package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TransportMethod;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MeansOfTransportBeforeBip implements MeansOfTransport {

  @NotEmpty(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.id.not.empty}")
  private String id = null;

  @NotNull(
      groups = NotificationHighRiskFieldValidation.class,
      message =
              "{uk.gov.defra.tracesx.notificationschema.representation.partone"
                      + ".meansoftransportfromentrypoint.type.not.null}")
  @NotNull(
      groups = NotificationCvedaEuFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.type.eucveda.not.null}")
  private TransportMethod type = null;

  @NotEmpty(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.document.not.empty}")
  private String document = null;
}
