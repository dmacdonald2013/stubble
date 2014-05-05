package com.cream.stubble.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * A response to return back to the client on request
 *
 * @author David MacDonald
 */
@XmlRootElement(name="output")
public class HttpOutput implements Serializable {

    private int responseCode = 200;
    private String body;
    private List<HttpHeader> headers;

    public HttpOutput() {

    }

    @XmlElement(name="responseCode")
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @XmlElement(name="body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @XmlElement(name="headers")
    public List<HttpHeader> getHeaders() {
        return Collections.unmodifiableList(headers);
    }

    public void setHeaders(List<HttpHeader> headers) {
        this.headers = headers;
    }
}
