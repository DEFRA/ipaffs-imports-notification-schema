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
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationAfterMeansOfTransport;

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
public class MeansOfTransportAfterBip implements MeansOfTransport {

  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.id"
              + ".not.empty}",
      groups = NotificationAfterMeansOfTransport.class)
  private String id = null;

  @NotNull(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport.type"
              + ".not.null}",
      groups = NotificationAfterMeansOfTransport.class)
  private TransportMethod type = null;

  @NotEmpty(
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.meansoftransport"
              + ".document.not.empty}",
      groups = NotificationAfterMeansOfTransport.class)
  private String document = null;
}
