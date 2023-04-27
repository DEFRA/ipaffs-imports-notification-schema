package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppSealsAndContainers;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskNonChedppFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ChedppSealsAndContainers(
    groups = NotificationChedppFieldValidation.class)
public class NotificationSealsContainers {

  @NotBlank(
      groups = {
          NotificationCedFieldValidation.class,
          NotificationCvedaFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message = "Seal number cannot be empty")
  private String sealNumber;

  @NotBlank(
      groups = NotificationHighRiskNonChedppFieldValidation.class,
      message = "Enter container or road trailer number")
  private String containerNumber;

  private boolean officialSeal;
  private String resealedSealNumber = null;
}
