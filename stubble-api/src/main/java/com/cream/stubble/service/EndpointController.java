package com.cream.stubble.service;

import com.cream.stubble.domain.HttpHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endpoints")
public class EndpointController {

    //can't return array with XML
    @RequestMapping(method=RequestMethod.GET)
    public List<HttpHeader> getAll() {
        List<HttpHeader> headers = new ArrayList<>();
        headers.add(new HttpHeader("foo","baz"));
        return headers;
    }

    @RequestMapping(method=RequestMethod.GET,produces={"application/xml"})
    public HttpHeaders getAllXml() {
        //we need to wrap up XML
        return new HttpHeaders(getAll());
    }
}

@XmlRootElement(name="headers")
@XmlSeeAlso({HttpHeader.class})
class HttpHeaders implements Serializable {
    private List<HttpHeader> headers;

    HttpHeaders() {
        //for Jaxb
    }

    public HttpHeaders(List<HttpHeader> headers) {
        this.headers = headers;
    }

    @XmlAnyElement(lax=true)
    public List<HttpHeader> getHeaders() {
        return headers;
    }

}