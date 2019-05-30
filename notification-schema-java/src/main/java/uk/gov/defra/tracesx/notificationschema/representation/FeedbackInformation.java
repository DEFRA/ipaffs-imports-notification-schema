package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AuthorityType;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public final class FeedbackInformation {

  private AuthorityType authorityType;
  private Boolean consignmentArrival;
  private Boolean consignmentConformity;
  private String consignmentNoArrivalReason;

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate destructionDate;

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    FeedbackInformation that = (FeedbackInformation) object;

    return new EqualsBuilder()
        .append(authorityType, that.authorityType)
        .append(consignmentArrival, that.consignmentArrival)
        .append(consignmentConformity, that.consignmentConformity)
        .append(consignmentNoArrivalReason, that.consignmentNoArrivalReason)
        .append(destructionDate, that.destructionDate)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(authorityType)
        .append(consignmentArrival)
        .append(consignmentConformity)
        .append(consignmentNoArrivalReason)
        .append(destructionDate)
        .toHashCode();
  }
}
