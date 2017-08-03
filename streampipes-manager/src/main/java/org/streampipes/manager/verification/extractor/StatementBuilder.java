package org.streampipes.manager.verification.extractor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.openrdf.model.Model;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.Rio;
import org.openrdf.rio.UnsupportedRDFormatException;

import org.streampipes.commons.config.old.Configuration;
import org.streampipes.commons.exceptions.SepaParseException;

public class StatementBuilder {

	public static Model extractStatements(String graphData) throws SepaParseException
	{
		try {
			return Rio.parse(getGraphDataAsStream(graphData), "", Configuration.getInstance().RDF_FORMAT);
		} catch (RDFParseException | UnsupportedRDFormatException | IOException e) {
			throw new SepaParseException();
		}
	}
	
	private static InputStream getGraphDataAsStream(String graphData)
	{
		InputStream stream = new ByteArrayInputStream(
				graphData.getBytes(StandardCharsets.UTF_8));
		
		return stream;
	}
}
