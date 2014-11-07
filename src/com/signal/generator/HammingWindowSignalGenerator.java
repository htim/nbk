package com.signal.generator;

import com.signal.entities.Signal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htim on 29.10.14.
 */
public class HammingWindowSignalGenerator implements BaseWindowSignalGenerator {

    @Override
    public Signal perform(int sampleRate, int numberOfSamples, int pulseWidthInSamples) {


        Signal signalInstance = new Signal();

        Integer startSample = numberOfSamples/2 - pulseWidthInSamples/2;

        List<Double> samples = new ArrayList();

        for (int i = 0; i < numberOfSamples; i++) {
            if (i>=startSample && i<startSample+pulseWidthInSamples) {
                samples.add(1000*(0.54-0.46*Math.cos(2*Math.PI*i/(pulseWidthInSamples-1))));
            } else {
                samples.add(0.0);
            }
        }

        signalInstance.setData(samples);

        return signalInstance;

    }
}
