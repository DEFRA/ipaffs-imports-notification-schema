package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppSealsAndContainers;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskNonChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationSingleCedValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationSingleCvedaValidation;

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
  @NotBlank(
      groups = {
          NotificationSingleCedValidation.class,
          NotificationSingleCvedaValidation.class
      },
      message = "Add seal number")
  @RetrospectiveCloningProperty()
  private String sealNumber;

  @NotBlank(
      groups = {
          NotificationHighRiskNonChedppFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message = "Enter container or road trailer number")
  @NotBlank(
      groups = {
          NotificationSingleCedValidation.class,
          NotificationSingleCvedaValidation.class
      },
      message = "Add container or trailer number")
  @RetrospectiveCloningProperty()
  private String containerNumber;

  @RetrospectiveCloningProperty()
  private boolean officialSeal;
  private String resealedSealNumber = null;
}
