package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TransportType;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public final class DetailsOnReExport {

  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate date;

  @Size(min = 1, max = 50)
  private String meansOfTransportNo;

  private TransportType transportType;

  @Size(min = 1, max = 32)
  private String document;

  @Size(min = 2, max = 2)
  @Pattern(regexp = "^[A-Z][A-Z]$")
  private String countryOfReDispatching;

  private String exitBIP;

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof DetailsOnReExport)) {
      return false;
    }

    DetailsOnReExport that = (DetailsOnReExport) object;

    return new EqualsBuilder()
        .append(date, that.date)
        .append(meansOfTransportNo, that.meansOfTransportNo)
        .append(transportType, that.transportType)
        .append(document, that.document)
        .append(countryOfReDispatching, that.countryOfReDispatching)
        .append(exitBIP, that.exitBIP)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(date)
        .append(meansOfTransportNo)
        .append(transportType)
        .append(document)
        .append(countryOfReDispatching)
        .append(exitBIP)
        .toHashCode();
  }
}
