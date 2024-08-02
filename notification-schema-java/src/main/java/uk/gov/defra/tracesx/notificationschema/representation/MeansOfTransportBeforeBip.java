package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TransportMethod;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpEuTransportFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationSingleCedValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationSingleCvedpFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MeansOfTransportBeforeBip implements MeansOfTransport {

  @NotEmpty(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.id.not.empty}")
  @NotEmpty(
      groups = NotificationChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.id.chedpp.not.empty}")
  @NotEmpty(
      groups = NotificationCvedaEuFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.id.eucveda.not.empty}")
  @NotEmpty(
      groups = NotificationCvedpEuTransportFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.id.eucvedp.not.empty}")

  @NotEmpty(
      groups = NotificationSingleCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.id.singlechedp.not.empty}")
  @RetrospectiveCloningProperty()
  private String id = null;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
      },
      message =
              "{uk.gov.defra.tracesx.notificationschema.representation.partone"
                      + ".meansoftransportfromentrypoint.type.not.null}")
  @NotNull(
      groups = NotificationCvedaEuFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.type.eucveda.not.null}")
  @NotNull(
      groups = NotificationCvedpEuFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.type.eucvedp.not.null}")
  @NotNull(
      groups = NotificationChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.chedpp.type.not.null}")
  @NotNull(
      groups = NotificationHighRiskEuCedFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.type.euced.not.null}")
  @NotNull(
      groups = NotificationSingleCedValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.type.singleced.not.null}")
  @RetrospectiveCloningProperty()
  private TransportMethod type = null;

  @NotEmpty(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.document.not.empty}")
  @NotEmpty(
      groups = NotificationChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.document.chedpp.not.empty}")
  @NotEmpty(
      groups = {
          NotificationCvedpEuTransportFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.document.eucvedp.not.empty}")
  @NotEmpty(
      groups = {
          NotificationSingleCvedpFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.document.singlechedp.not.empty}")
  @NotEmpty(
      groups = {
          NotificationCvedaEuFieldValidation.class,
      },
      message =
           "{uk.gov.defra.tracesx.notificationschema.representation.partone"
              + ".meansoftransportfromentrypoint.document.eucveda.not.empty}")
  private String document = null;
}
