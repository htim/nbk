package com.signal.generator;

import com.signal.entities.Signal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htim on 29.10.14.
 */
public class SawSignalGenerator implements BaseSignalGenerator {

    @Override
    public Signal perform(int sampleRate, int numberOfSamples, int amplitude, int frequency) {

        Signal signalInstance = new Signal();

        Double period = (double)sampleRate/(double)frequency;
        int c = 0;

        List<Double> samples = new ArrayList();

        for (int i = 0; i < numberOfSamples; i++) {

            if (c>=period) c = 0;
            samples.add(amplitude-amplitude*(c/period));
            c++;

        }
        signalInstance.setData(samples);
        return signalInstance;

    }
}
