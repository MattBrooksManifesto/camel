package uk.co.manifesto.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFirstRouteTest extends CamelSpringTestSupport{
	

	@Test
	public void testRoute() throws Exception{
		
		String body = "<hello/>";
		
		MockEndpoint endpoint = getMockEndpoint("mock:result");
		
		endpoint.setExpectedCount(1);
		
		template.sendBody("direct:test", body);
		
		Exchange ex = endpoint.getExchanges().get(0);
		Message message = ex.getIn();
		
		assertEquals("helloWorld", message.getHeader("testHeader"));
		assertEquals("OK", message.getBody());
		
		endpoint.assertIsSatisfied();
		
	}

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("/META-INF/spring/camel-context.xml");
	}

	
}
