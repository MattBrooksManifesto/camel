package uk.co.manifesto.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import uk.co.manifesto.camel.beans.JsonProcess;
import uk.co.manifesto.camel.classes.Json;

public class JsonExampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("direct:json")
			.unmarshal().json(JsonLibrary.Jackson, Json.class)
			.bean(JsonProcess.class)
			.marshal().json(JsonLibrary.Jackson)
			.convertBodyTo(String.class)
			.to("mock:jsonResult");
		
	}

}
