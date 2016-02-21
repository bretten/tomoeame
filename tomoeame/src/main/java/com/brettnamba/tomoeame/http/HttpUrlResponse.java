package com.brettnamba.tomoeame.http;

import java.net.HttpURLConnection;

/**
 * HTTP response object that is used with HttpUrlConnectionRequest
 *
 * @author Brett Namba (https://github.com/bretten)
 */
public class HttpUrlResponse {

    /**
     * The HTTP request object
     */
    protected HttpUrlConnectionRequest mRequest;

    /**
     * The HTTP response code
     */
    protected int mResponseCode;

    /**
     * Constructor
     *
     * @param request The HTTP request object
     */
    public HttpUrlResponse(HttpUrlConnectionRequest request) {
        this.mRequest = request;
        this.mResponseCode = this.mRequest.getResponseCode();
    }

    /**
     * Determines if this request was successful
     *
     * @return True if the request was successful
     */
    public boolean isSuccess() {
        return this.mResponseCode >= HttpURLConnection.HTTP_OK &&
                this.mResponseCode < HttpURLConnection.HTTP_MULT_CHOICE;
    }

    /**
     * Determines if the request had a client error
     *
     * @return True if there was a client error
     */
    public boolean isClientError() {
        return this.mResponseCode >= HttpURLConnection.HTTP_BAD_REQUEST &&
                this.mResponseCode < HttpURLConnection.HTTP_INTERNAL_ERROR;
    }

    /**
     * Determines if the request had a server error
     *
     * @return True if there was a server error
     */
    public boolean isServerError() {
        return this.mResponseCode >= HttpURLConnection.HTTP_INTERNAL_ERROR &&
                this.mResponseCode < 600;
    }

    /**
     * Determines if the request had an error
     *
     * @return True if there was an error
     */
    public boolean isError() {
        return this.isClientError() || this.isServerError();
    }

}
