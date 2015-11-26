
package uk.co.manifesto.camel.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sample"
})
public class Json {

    @JsonProperty("sample")
    private Sample sample;

    /**
     * 
     * @return
     *     The sample
     */
    @JsonProperty("sample")
    public Sample getSample() {
        return sample;
    }

    /**
     * 
     * @param sample
     *     The sample
     */
    @JsonProperty("sample")
    public void setSample(Sample sample) {
        this.sample = sample;
    }


}
