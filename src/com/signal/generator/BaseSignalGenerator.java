package com.signal.generator;

import com.signal.entities.Signal;

/**
 * Created by htim on 28.10.14.
 */
public interface BaseSignalGenerator {

    public Signal perform(int sampleRate, int numberOfSamples, int amplitude, int frequency);

}
