package com.cream.stubble.domain;

import java.util.List;

/**
 * A representation of an HTTP endpoint that will subscribe and return messages
 *
 * @author David MacDonald
 */
public class HttpEndpoint {
    private String endpointUri;
    private String description;
    private List<HttpOutput> outputs;
}
