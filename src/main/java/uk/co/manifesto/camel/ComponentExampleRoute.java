package uk.co.manifesto.camel;

import org.apache.camel.builder.RouteBuilder;

public class ComponentExampleRoute  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:src/test/resources/files")
			.convertBodyTo(String.class)
			.to("mock:component");
	}

}
