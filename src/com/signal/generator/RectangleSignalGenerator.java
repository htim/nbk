package com.signal.generator;

import com.signal.entities.Signal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htim on 29.10.14.
 */
public class RectangleSignalGenerator implements BaseSignalGenerator {

    @Override
    public Signal perform(int sampleRate, int numberOfSamples, int amplitude, int frequency) {

        Signal signalInstance = new Signal();


        Double period = (double)sampleRate/(double)frequency/2;

        List<Double> samples = new ArrayList<>();

        int c = 1;
        int counter = 0;

        for (int i = 0; i < numberOfSamples; i++) {

            if (counter>=period) {
                counter = 0;
                c*=-1;
            }
            samples.add((double)amplitude*c);
            counter++;
        }

        signalInstance.setData(samples);
        return signalInstance;

    }
}
