package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForNonConformingEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.InternalMarketPurpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.PurposeForInternalMarket;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Purpose {

  private Boolean conformsToEU;

  @NotNull(
      groups = PurposeForInternalMarket.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose"
              + ".internalmarketpurpose.not.null}")
  private InternalMarketPurpose internalMarketPurpose;
  private String thirdCountryTranshipment;
  private ForNonConformingEnum forNonConforming;
  private String regNumber;
  private String shipName;
  private String shipPort;
  private String exitBIP;
  private String thirdCountry;
  private List<String> transitThirdCountries;
  private ForImportOrAdmissionEnum forImportOrAdmission;
  private String exitDate;
  private String finalBIP;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose.purposeGroup"
              + ".not.null}")
  private PurposeGroupEnum purposeGroup;
}
