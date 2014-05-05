package com.cream.stubble.service;

import com.cream.stubble.domain.HttpEndpoint;
import com.cream.stubble.domain.HttpHeader;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endpoints")
public class EndpointController {

    //todo: add pretty printing
    //todo: only return outputs contents if specified (embed/expand parameter)
    //todo: gzip
    //todo: versioning
    //todo: standard exceptions
    //todo: pagination
    //todo: rate limit?
    //todo: caching and ETag for optimistic locking

    //can't return array with XML
    @RequestMapping(method=RequestMethod.GET)
    public List<HttpEndpoint> getAll() {
        List<HttpEndpoint> endpoints = new ArrayList<>();
        endpoints.add(new HttpHeader("foo", "baz"));
        return endpoints;
    }

    //get all outputs

    @RequestMapping(method=RequestMethod.GET,produces={"application/xml"})
    public HttpEndpoints getAllXml() {
        //we need to wrap up XML
        return new HttpEndpoints();
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public HttpEndpoint getEndpoint(@PathVariable("id") int endpointId) {

    }

    //should return a 201 link
    @RequestMapping(method=RequestMethod.POST)
    public HttpEndpoint createEndpoint(@RequestBody HttpEndpoint endpoint) {

    }

    //return the id only?
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public HttpEndpoint updateEndpoint(@PathVariable("id") int endpointId,@RequestBody HttpEndpoint endpoint) {

    }

    //should return 204
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void deleteEndpoint(@PathVariable("id") int endpointId) {

    }

}

@XmlRootElement(name="endpoints")
@XmlSeeAlso({HttpEndpoint.class}) //ensure we have this in the jaxb context
class HttpEndpoints implements Serializable {
    private List<HttpEndpoint> endpoints;

    private HttpEndpoints() {
        //for Jaxb
    }

    public HttpEndpoints(List<HttpEndpoint> endpoints) {
        this.endpoints = endpoints;
    }

    @XmlAnyElement(lax=true)
    public List<HttpEndpoint> getEndpoints() {
        return endpoints;
    }

}