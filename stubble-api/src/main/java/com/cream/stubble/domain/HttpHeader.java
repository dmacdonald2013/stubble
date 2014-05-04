package com.cream.stubble.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A simple string->string value for headers
 *
 * @author David MacDonald
 */
@XmlRootElement(name="header")
public class HttpHeader {
    private String name;
    private String value;

    HttpHeader() {
        //jaxb wants this
    }

    public HttpHeader(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @XmlElement(name="name")
    public String getName() {
        return this.name;
    }

    @XmlElement(name="value")
    public String getValue() {
        return this.value;
    }
}
