package uk.co.manifesto.camel;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.manifesto.camel.utils.FileReader;

public class ContentBasedRouterRouteTest extends CamelSpringTestSupport{

	@Test
	public void testRoute() throws Exception{
		
		String body = FileReader.read("../camel/src/test/resources/files/payment.xml");
		
		MockEndpoint endpointEur = getMockEndpoint("mock:euro");
		MockEndpoint endpointUsd = getMockEndpoint("mock:usd");
		
		endpointEur.setExpectedCount(1);
		endpointUsd.setExpectedCount(0);
		
		template.sendBody("direct:cbr", body);
		
		assertMockEndpointsSatisfied();
	}
	
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("/META-INF/spring/camel-context.xml");
	}
	
}
