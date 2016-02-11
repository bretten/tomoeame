package com.brettnamba.tomoeame.http;

import android.support.v4.util.Pair;

import java.util.List;

/**
 * Establishes a contract for a collection of HTTP request parameters.  Implementing classes can
 * handle the parameters as they see fit, but should return all of the parameters in a collection
 * of key-value pairs so they can be added to a HttpUrlConnectionRequest.
 *
 * @author Brett Namba (https://github.com/bretten)
 */
public interface RequestParameters {

    /**
     * Returns all of the request parameters as a collection of key-value pairs
     *
     * @return The request parameters as a collection of key-value pairs
     */
    List<Pair<String, String>> getAsCollection();

}
