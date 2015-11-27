package uk.co.manifesto.camel;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentExampleRouteTest extends CamelSpringTestSupport{
	
	@Test
	public void testRoute() throws Exception{
		
		MockEndpoint endpoint = getMockEndpoint("mock:component");
		
		endpoint.setExpectedCount(2);
		
		endpoint.assertIsSatisfied();
		
	}
	
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("/META-INF/spring/camel-context.xml");
	}
	
}
