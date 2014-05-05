package com.cream.stubble.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

/**
 * A representation of an HTTP endpoint that will subscribe and return messages
 *
 * @author David MacDonald
 */
@XmlRootElement(name="endpoint")
public class HttpEndpoint {
    private String endpointUri;
    private String description;
    private List<HttpOutput> outputs;

    @XmlElement(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name="outputs")
    public List<HttpOutput> getOutputs() {
        return Collections.unmodifiableList(outputs);
    }

    public void setOutputs(List<HttpOutput> outputs) {
        this.outputs = outputs;
    }

    @XmlElement(name="endpointUri")
    public String getEndpointUri() {
        return endpointUri;
    }

    public void setEndpointUri(String endpointUri) {
        this.endpointUri = endpointUri;
    }

}
