package com.signal.generator;

import com.signal.entities.Signal;

/**
 * Created by htim on 29.10.14.
 */
public interface BaseWindowSignalGenerator {

    public Signal perform(int sampleRate, int numberOfSamples, int pulseWidthInSamples);

}
