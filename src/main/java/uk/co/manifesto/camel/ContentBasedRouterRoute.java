package uk.co.manifesto.camel;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouterRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:src/test/resources/payment?noop=true&fileName=payment.xml")
			
			.choice()
				.when(xpath("Payment/Currency = 'eur'")).to("mock:euro")
				
				.when(xpath("Payment/Currency = 'usd'")).to("mock:usd")
				
				.otherwise().to("direct:error");
		
	}

}
