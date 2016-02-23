package com.brettnamba.tomoeame.http;

import android.content.Context;

import org.apache.http.client.methods.HttpDelete;

import java.net.HttpURLConnection;
import java.net.ProtocolException;

/**
 * Implementation of HttpUrlConnectionRequest that sends a simple DELETE request.
 *
 * @author Brett Namba (https://github.com/bretten)
 */
public class HttpUrlDeleteRequest extends HttpUrlConnectionRequest {

    /**
     * Constructs an instance only with the request URL
     *
     * @param context    The current Context
     * @param requestUrl The HTTP request URL
     */
    public HttpUrlDeleteRequest(Context context, String requestUrl) {
        super(context, requestUrl);
    }

    /**
     * Constructs an instance with authentication information and adds the authentication header to
     * the collection of request headers
     *
     * @param context    The current Context
     * @param requestUrl The HTTP request URL
     * @param authToken  The authentication token
     */
    public HttpUrlDeleteRequest(Context context, String requestUrl, String authToken) {
        super(context, HttpDelete.METHOD_NAME, requestUrl, authToken);
    }

    /**
     * Sets up the request
     *
     * @param httpUrlConnection The HTTP request object that will be setup
     * @throws ProtocolException
     */
    @Override
    protected void setupRequest(HttpURLConnection httpUrlConnection) throws ProtocolException {
        // Set request method to DELETE
        httpUrlConnection.setRequestMethod(HttpDelete.METHOD_NAME);
    }

    /**
     * Determines the request body length, which is 0 in this case
     *
     * @return 0
     */
    @Override
    protected long determineRequestBodyLength() {
        return 0;
    }

    /**
     * Request body not yet implemented
     *
     * TODO: HTTP specs indicate request bodies are allowed in DELETE requests, so add support
     */
    @Override
    protected void writeToRequestStream() {
        throw new UnsupportedOperationException();
    }

}
