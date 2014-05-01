package com.cream.stubble.domain;

import java.util.List;

/**
 * A response to return back to the client on request
 *
 * @author David MacDonald
 */
public class HttpOutput {
    private int responseCode = 200;
    private String body;
    private List<HttpHeader> headers;
}
