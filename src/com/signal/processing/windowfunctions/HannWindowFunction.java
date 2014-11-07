package com.signal.processing.windowfunctions;

import com.signal.entities.Signal;
import com.signal.processing.WindowFunction;

import java.util.Arrays;

/**
 * Created by htim on 01.11.14.
 */
public class HannWindowFunction implements WindowFunction {

    public Signal evaluateFunction(Signal signalIn) {

        Signal signalOut = new Signal();
        Double[] outarr = new Double[signalIn.getData().size()];
        int dimension = signalIn.getData().size();
        for (int i = 0; i < dimension; i++) {
            outarr[i] = (double)signalIn.getData().toArray()[i]*(0.5-0.5*Math.cos((2*Math.PI*i)/(dimension-1)));
        }

        signalOut.setData(Arrays.asList(outarr));

        return signalOut;
    }
}
