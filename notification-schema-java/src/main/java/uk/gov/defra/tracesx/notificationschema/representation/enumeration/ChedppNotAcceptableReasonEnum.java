package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ChedppNotAcceptableReasonEnum {
  DOCPHMDM("doc-phmdm"),
  DOCPHMDII("doc-phmdii"),
  DOCPA("doc-pa"),
  DOCPIC("doc-pic"),
  DOCPILL("doc-pill"),
  DOCPED("doc-ped"),
  DOCPMOD("doc-pmod"),
  DOCPFI("doc-pfi"),
  DOCPNOL("doc-pnol"),
  DOCPCNE("doc-pcne"),
  DOCPADM("doc-padm"),
  DOCPADI("doc-padi"),
  DOCPPNI("doc-ppni"),
  DOCPF("doc-pf"),
  DOCPO("doc-po"),
  DOCNCEVD("doc-ncevd"),
  DOCNCPQEFI("doc-ncpqefi"),
  DOCNCPQEBEC("doc-ncpqebec"),
  DOCNCTS("doc-ncts"),
  DOCNCO("doc-nco"),
  DOCORII("doc-orii"),
  DOCORSR("doc-orsr"),
  ORIORRNU("ori-orrnu"),
  PHYORPP("phy-orpp"),
  PHYORHO("phy-orho"),
  PHYIS("phy-is"),
  PHYORSR("phy-orsr"),
  OTHCNL("oth-cnl"),
  OTHO("oth-o");

  private String value;

  ChedppNotAcceptableReasonEnum(String value) {
    this.value = value;
  }

  public static ChedppNotAcceptableReasonEnum fromValue(String text) {
    return Arrays.stream(ChedppNotAcceptableReasonEnum.values())
        .filter(label -> label.value.equals(text))
        .findFirst()
        .orElse(null);
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}