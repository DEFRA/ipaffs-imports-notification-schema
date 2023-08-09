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
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredCEDorChedppValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.TransporterDetailsRequiredEuCvedaValidation;
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
          TransporterDetailsRequiredCEDorChedppValidation.class})
  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.id"
              + ".eucveda.not.empty}",
      groups = {TransporterDetailsRequiredEuCvedaValidation.class})
  private String id = null;

  @NotNull(
      message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.type"
          + ".eucveda.not.null}",
      groups = {TransporterDetailsRequiredEuCvedaValidation.class})
  @NotNull(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.type"
              + ".not.null}",
      groups = {TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDorChedppValidation.class})
  private TransportMethod type = null;

  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport"
              + ".document.not.empty}",
      groups = {
          TransporterDetailsRequiredValidation.class,
          TransporterDetailsRequiredCEDorChedppValidation.class})
  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport"
              + ".document.eucveda.not.empty}",
      groups = {
          TransporterDetailsRequiredEuCvedaValidation.class})
  private String document = null;
}
