package uk.co.manifesto.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.manifesto.camel.utils.FileReader;

public class JsonExampleRouteTest extends CamelSpringTestSupport{
	
	@Test
	public void testRoute() throws Exception{
		
		String body = FileReader.read("../camel/src/test/resources/files/sample.json");
		
		MockEndpoint endpoint = getMockEndpoint("mock:jsonResult");
		
		endpoint.setExpectedCount(1);
		
		template.sendBody("direct:json", body);
		
		Exchange ex = endpoint.getExchanges().get(0);
		Message message = ex.getIn();
		
		assertStringContains(message.getBody().toString(), "outputId");
		assertStringContains(message.getBody().toString(), "outputValue");
		
		endpoint.assertIsSatisfied();
		
	}
	
	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("/META-INF/spring/camel-context.xml");
	}
	
}
