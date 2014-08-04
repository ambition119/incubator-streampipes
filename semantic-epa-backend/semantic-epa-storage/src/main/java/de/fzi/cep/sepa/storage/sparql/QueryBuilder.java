package de.fzi.cep.sepa.storage.sparql;

public class QueryBuilder {

	public static String buildListSEPQuery()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(getPrefix())
			.append("select ?a where { ?a rdf:type sepa:SemanticEventProducer }");
		
		return builder.toString();
	}
	
	private static String getPrefix()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("PREFIX sepa:<http://event-processing.org/sepa#>\n")
		.append("PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n");
		
		return builder.toString();
	}
	
	public static String getMatching()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(getPrefix())
		.append("select ?d where {?a rdf:type sepa:EventProperty. ?b rdf:type sepa:EventSchema. ?b sepa:hasEventProperty ?a. ?a sepa:hasPropertyName ?d}");
		return builder.toString();
	}
	
}
