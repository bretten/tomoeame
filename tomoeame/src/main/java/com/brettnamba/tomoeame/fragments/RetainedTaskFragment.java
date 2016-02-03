package com.brettnamba.tomoeame.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.brettnamba.tomoeame.os.AsyncListenerTask;

/**
 * Fragment that is used to retain a reference to an AsyncTask.  The state is retained
 * by setting setRetainInstance(true).  When this Fragment is attached to an Activity it sets
 * the references to the newly attached Activity.  When the Fragment is detached from an Activity
 * it removes all references to the detached Activity.  As a result the Fragment will never
 * reference an Activity that may be destroyed.
 *
 * @author Brett Namba (https://github.com/bretten)
 */
public class RetainedTaskFragment extends Fragment {

    /**
     * The AsyncTask that is retained
     */
    private AsyncListenerTask mTask;

    /**
     * Tag to be used with the FragmentManager
     */
    public static final String TAG = "retained_fragment";

    /**
     * onCreate
     *
     * Sets the instance of to be retained throughout the parent Activity's lifecycle
     *
     * @param savedInstanceState Previous state data if not null
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Flag the Fragment to be retained
        this.setRetainInstance(true);
    }

    /**
     * onAttach
     *
     * Associates any references to the new Activity
     *
     * @param activity The Activity that the Fragment is being attached to
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.mTask != null) {
            // Set the newly attached Activity as the listener for the AsyncTask
            this.mTask.setListener((AsyncListenerTask.TaskListener) activity);
        }
    }

    /**
     * onDetach
     *
     * Removes all references to the Activity being detached
     */
    @Override
    public void onDetach() {
        super.onDetach();
        // Remove the listener from the AsyncTask
        if (this.mTask != null) {
            this.mTask.removeListener();
        }
    }

    /**
     * Sets the AsyncTask
     *
     * @param task The AsyncTask to be retained
     */
    public void setTask(AsyncListenerTask task) {
        this.mTask = task;
    }

    /**
     * Determines if the associated background task is running
     *
     * @return True if it is running, otherwise false
     */
    public boolean isTaskRunning() {
        return this.mTask != null && this.mTask.getStatus() == AsyncTask.Status.RUNNING;
    }

    /**
     * Using the specified FragmentManager, will find the already added instance of
     * RetainedTaskFragment by its tag.  If it does not exist, will instantiate it and add it to
     * the FragmentManager.
     *
     * @param fm The FragmentManager
     * @return The RetainedTaskFragment found in the FragmentManager or a new instance
     */
    public static RetainedTaskFragment findOrCreate(FragmentManager fm) {
        RetainedTaskFragment fragment = (RetainedTaskFragment) fm.findFragmentByTag(TAG);
        if (fragment == null) {
            fragment = new RetainedTaskFragment();
            fm.beginTransaction().add(fragment, TAG).commit();
        }
        return fragment;
    }

    /**
     * Using the specified FragmentManager, will find the already added instance of
     * RetainedTaskFragment by the specified tag.  If it does not exist, will instantiate it and
     * add it to the FragmentManager.
     *
     * @param fm  The FragmentManager
     * @param tag The tag that will be used with the FragmentManager
     * @return The RetainedTaskFragment found in the FragmentManager or a new instance
     */
    public static RetainedTaskFragment findOrCreate(FragmentManager fm, String tag) {
        RetainedTaskFragment fragment = (RetainedTaskFragment) fm.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = new RetainedTaskFragment();
            fm.beginTransaction().add(fragment, tag).commit();
        }
        return fragment;
    }

}
