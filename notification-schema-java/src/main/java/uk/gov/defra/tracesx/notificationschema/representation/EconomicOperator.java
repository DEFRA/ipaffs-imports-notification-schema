package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.EconomicOperatorStatus;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.EconomicOperatorType;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredEuCvedpValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EconomicOperator {

  @RetrospectiveCloningProperty()
  private String id;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class,
          TransporterDetailsRequiredEuCvedpValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.transporter.type.not"
              + ".null}")
  private EconomicOperatorType type;

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.transporter.status.not"
              + ".null}")
  @RetrospectiveCloningProperty()
  private EconomicOperatorStatus status;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class,
          TransporterDetailsRequiredEuCvedpValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.transporter"
              + ".companyname.not.null}")
  @RetrospectiveCloningProperty()
  private String companyName;

  private String individualName;

  private String approvalNumber;

  @RetrospectiveCloningProperty()
  private String otherIdentifier;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class,
          TransporterDetailsRequiredEuCvedpValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.transporter.address"
              + ".not.null}")
  @RetrospectiveCloningProperty()
  private EconomicOperatorAddress address;

  @RetrospectiveCloningProperty()
  private Integer tracesId;
}
