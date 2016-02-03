package com.brettnamba.tomoeame.os;

import android.os.AsyncTask;

/**
 * Abstraction of AsyncTask that is meant to use listeners when the
 * standard AsyncTask's methods are invoked
 *
 * In order to allow an Activity implement multiple listeners, a listener interface
 * is created for each Task so the callbacks can be differentiated.
 *
 * @param <Params>   Parameters sent to the Task on execution
 * @param <Progress> Progress units returned as the Task executes on the background thread
 * @param <Result>   The result of the background thread task
 * @author Brett Namba (https://github.com/bretten)
 */
public abstract class AsyncListenerTask<Params, Progress, Result>
        extends AsyncTask<Params, Progress, Result> {

    /**
     * Sets the listener for the AsyncTask
     *
     * @param listener The listener that handles the callbacks
     */
    public abstract void setListener(TaskListener listener);

    /**
     * Removes the listener that handles the callbacks
     */
    public abstract void removeListener();

    /**
     * Base TaskListener interface that all listeners should extend from
     */
    public interface TaskListener {
    }

}
