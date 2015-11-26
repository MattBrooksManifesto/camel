package uk.co.manifesto.camel;

import org.apache.camel.builder.RouteBuilder;

public class MyFirstRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("direct:test")
			.id("myFirstRoute")
			.setHeader("testHeader", simple("helloWorld"))
			.setBody(simple("OK"))
			.convertBodyTo(String.class)
			.to("mock:result");
		
	}

	
}
