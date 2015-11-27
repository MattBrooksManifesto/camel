package uk.co.manifesto.camel;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContentBasedRouterRouteTest extends CamelSpringTestSupport{

	@Test
	public void testRoute() throws Exception{
		
		MockEndpoint endpointEur = getMockEndpoint("mock:euro");
		MockEndpoint endpointUsd = getMockEndpoint("mock:usd");
		
		endpointEur.setExpectedCount(1);
		endpointUsd.setExpectedCount(0);
		
		assertMockEndpointsSatisfied();
	}
	
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("/META-INF/spring/camel-context.xml");
	}
	
}
