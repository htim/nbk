package com.signal.generator;

import com.signal.entities.Signal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htim on 29.10.14.
 */
public class CosineSignalGenerator implements BaseSignalGenerator {

    @Override
    public Signal perform(int sampleRate, int numberOfSamples, int amplitude, int frequency) {

        Signal signalInstance = new Signal();

        /*evaluating period of cosine*/
        Double period = (double)sampleRate/(double)frequency/2;

        List<Double> samples = new ArrayList();

        for (int i = 0; i < numberOfSamples; i++) {
            samples.add(amplitude*Math.cos(i * Math.PI / period));
        }

        signalInstance.setData(samples);
        return signalInstance;

    }
}
