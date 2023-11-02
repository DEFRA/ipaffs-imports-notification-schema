package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PartyType;
import uk.gov.defra.tracesx.notificationschema.validation.ErrorCodes;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskNonChedppFieldValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Party {

  private String id;

  @NotNull(groups = NotificationCvedaFieldValidation.class, message = ErrorCodes.NOT_NULL)
  private String name;

  private String companyId;

  private String companyName;

  @NotEmpty(
      groups = {
          NotificationHighRiskNonChedppFieldValidation.class,
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.personResponsible"
          + ".address.not.empty}")
  @NotEmpty(
      groups = {
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class
      },
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.personResponsible"
          + ".address.eucveda.not.empty}")
  private List<String> address;

  private String county;
  private String postCode;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class
      },
      message = ErrorCodes.NOT_NULL)
  private String country;

  private String city;
  private Integer tracesID;
  private PartyType type;
  private String approvalNumber;
  private String phone;
  private String fax;
  private String email;
  private String contactId;
}
