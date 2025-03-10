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
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredCEDValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredEuCvedPSoleValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredEuCvedaValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredEuCvedpValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredSingleChedpValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MeansOfTransportAfterBip implements MeansOfTransport {

  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.id"
              + ".not.empty}",
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class})
  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.id"
              + ".eucveda.not.empty}",
      groups = {
          TransporterDetailsRequiredEuCvedaValidation.class
      })
  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.id"
              + ".eucvedp.not.empty}",
      groups = {TransporterDetailsRequiredEuCvedPSoleValidation.class})
  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.id"
              + ".singlechedp.not.empty}",
      groups = {TransporterDetailsRequiredSingleChedpValidation.class})
  private String id = null;

  @NotNull(
      message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.type"
          + ".eucveda.not.null}",
      groups = {TransporterDetailsRequiredEuCvedaValidation.class})
  @NotNull(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.type"
              + ".eucvedp.not.null}",
      groups = {TransporterDetailsRequiredEuCvedpValidation.class})
  @NotNull(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.type"
              + ".not.null}",
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class})
  private TransportMethod type = null;

  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport"
              + ".document.not.empty}",
      groups = {
          TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDValidation.class})
  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport"
              + ".document.eucveda.not.empty}",
      groups = {
          TransporterDetailsRequiredEuCvedaValidation.class})
  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport"
              + ".document.eucvedp.not.empty}",
      groups = {
          TransporterDetailsRequiredEuCvedPSoleValidation.class})
  @NotEmpty(
      message =
      "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport"
      + ".document.singlechedp.not.empty}",
      groups = {
          TransporterDetailsRequiredSingleChedpValidation.class})
  private String document = null;
}
