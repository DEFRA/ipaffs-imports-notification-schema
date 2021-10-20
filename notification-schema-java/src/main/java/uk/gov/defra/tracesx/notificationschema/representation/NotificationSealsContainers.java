package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskNonChedppFieldValidation;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class NotificationSealsContainers {

  @NotBlank(
      groups = NotificationHighRiskFieldValidation.class,
      message = "Seal number cannot be empty")
  private String sealNumber;

  @NotBlank(
      groups = NotificationHighRiskNonChedppFieldValidation.class,
      message = "Container number cannot be empty")
  private String containerNumber;

  private boolean officialSeal;
  private String resealedSealNumber = null;
}
