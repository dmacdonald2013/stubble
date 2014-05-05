package com.cream.stubble.service;

import com.cream.stubble.domain.HttpOutput;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endpoints/{id}/outputs")
public class OutputController {

    //can't return array with XML
    @RequestMapping(method= RequestMethod.GET)
    public List<HttpOutput> getAll() {
        List<HttpOutput> outputs = new ArrayList<>();
        return outputs;
    }

    //get all outputs

    @RequestMapping(method=RequestMethod.GET,produces={"application/xml"})
    public HttpEndpoints getAllXml() {
        //we need to wrap up XML
        return new HttpOutputs();
    }

    @RequestMapping(value="/{outputId}",method=RequestMethod.GET)
    public HttpOutput getOutput(@PathVariable("id") int endpointId, @PathVariable("outputId") int outputId) {

    }

    @RequestMapping(value="/{outputId}",method=RequestMethod.POST)
    public HttpOutput createOutput(@PathVariable("id") int endpointId, @PathVariable("outputId") int outputId, @RequestBody HttpOutput output) {

    }

    //return the id only?
    @RequestMapping(value="/{outputId}",method=RequestMethod.PUT)
    public HttpOutput updateOutput(@PathVariable("id") int endpointId, @PathVariable("outputId") int outputId, @RequestBody HttpOutput output) {

    }

    //should return 204
    @RequestMapping(value="/{outputId}",method=RequestMethod.DELETE)
    public void deleteOutput(@PathVariable("id") int endpointId, @PathVariable("outputId") int outputId) {

    }
}

@XmlRootElement(name="outputs")
@XmlSeeAlso({HttpOutput.class}) //ensure we have this in the jaxb context
class HttpOutputs implements Serializable {
    private List<HttpOutput> outputs;

    private HttpOutputs() {
        //for Jaxb
    }

    public HttpOutputs(List<HttpOutput> outputs) {
        this.outputs = outputs;
    }

    @XmlAnyElement(lax=true)
    public List<HttpOutput> getOutputs() {
        return outputs;
    }

}
