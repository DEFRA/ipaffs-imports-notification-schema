package uk.gov.defra.tracesx.notificationschema.representation;

import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TransportMethod;

public interface MeansOfTransport {

  String getId();

  TransportMethod getType();

  String getDocument();
}
