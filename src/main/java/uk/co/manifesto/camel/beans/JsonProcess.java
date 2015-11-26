package uk.co.manifesto.camel.beans;

import uk.co.manifesto.camel.classes.Json;
import uk.co.manifesto.camel.classes.Sample;

public class JsonProcess {

	public void process(Json message){
		
		Sample sample = message.getSample();
		
		//do something to the message here
		
		sample.setId("outputId");
		sample.setValue("outputValue");
		
	}
	
}
