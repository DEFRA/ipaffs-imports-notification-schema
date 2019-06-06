package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TransportMethod;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MeansOfTransportBeforeBip implements MeansOfTransport {

  @NotEmpty(
      groups = NotificationFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notification.representation.partone"
              + ".meansoftransportfromentrypoint.id.not.empty}")
  private String id = null;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notification.representation.partone"
              + ".meansoftransportfromentrypoint.type.not.null}")
  private TransportMethod type = null;

  private String document = null;
}
