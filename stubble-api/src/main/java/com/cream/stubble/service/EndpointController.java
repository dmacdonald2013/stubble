package com.cream.stubble.service;

import com.cream.stubble.domain.HttpHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
