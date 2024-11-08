package uk.gov.defra.tracesx.notificationschema.representation;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.COMMODITY_GROUP;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.LOW_RISK_ARTICLE_72_COMMODITY;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.QUANTITY;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComplementParameterSetTest {

  @Test
  void isArticle72_ReturnsFalse_WhenDoesNotContainLowRiskArticle72CommodityKey() {
    ComplementParameterSet complementParameterSet = ComplementParameterSet.builder()
        .keyDataPair(List.of(
            ComplementParameterSetKeyDataPair.builder().key(QUANTITY).data("1").build(),
            ComplementParameterSetKeyDataPair.builder().key(COMMODITY_GROUP).data("true").build()
        ))
        .build();

    assertThat(complementParameterSet.isArticle72()).isFalse();
  }

  @Test
  void isArticle72_ReturnsFalse_WhenLowRiskArticle72CommodityIsFalse() {
    ComplementParameterSet complementParameterSet = ComplementParameterSet.builder()
        .keyDataPair(List.of(
            ComplementParameterSetKeyDataPair.builder().key(QUANTITY).data("1").build(),
            ComplementParameterSetKeyDataPair.builder().key(LOW_RISK_ARTICLE_72_COMMODITY)
                .data("false").build()
        ))
        .build();

    assertThat(complementParameterSet.isArticle72()).isFalse();
  }

  @Test
  void isArticle72_ReturnsTrue_WhenLowRiskArticle72CommodityIsTrue() {
    ComplementParameterSet complementParameterSet = ComplementParameterSet.builder()
        .keyDataPair(List.of(
            ComplementParameterSetKeyDataPair.builder().key(QUANTITY).data("1").build(),
            ComplementParameterSetKeyDataPair.builder().key(LOW_RISK_ARTICLE_72_COMMODITY)
                .data("true").build()
        ))
        .build();

    assertThat(complementParameterSet.isArticle72()).isTrue();
  }
}
