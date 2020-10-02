package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

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

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}