package com.signal.generator;

import com.signal.entities.Signal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htim on 29.10.14.
 */
public class ConstantSignalGenerator implements BaseSignalGenerator {

    @Override
    public Signal perform(int sampleRate, int numberOfSamples, int amplitude, int frequency) {

        Signal signalInstance = new Signal();

        List<Double> samples = new ArrayList<>();

        for (int i = 0; i < numberOfSamples; i++) {
            samples.add((double)amplitude);
        }

        signalInstance.setData(samples);
        return signalInstance;

    }
}
