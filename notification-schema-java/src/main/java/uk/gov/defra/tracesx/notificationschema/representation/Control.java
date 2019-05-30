package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ConsignmentLeave;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public final class Control {

  private FeedbackInformation feedbackInformation;
  private DetailsOnReExport detailsOnReExport;
  private OfficialInspector officialInspector;
  private ConsignmentLeave consignmentLeave;

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Control control = (Control) object;

    return new EqualsBuilder()
        .append(feedbackInformation, control.feedbackInformation)
        .append(detailsOnReExport, control.detailsOnReExport)
        .append(officialInspector, control.officialInspector)
        .append(consignmentLeave, control.consignmentLeave)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(feedbackInformation)
        .append(detailsOnReExport)
        .append(officialInspector)
        .append(consignmentLeave)
        .toHashCode();
  }
}
