package com.signal.processing.windowfunctions;

import com.signal.entities.Signal;
import com.signal.processing.WindowFunction;

import java.util.Arrays;

/**
 * Created by htim on 01.11.14.
 */
public class NuttallWindowFunction implements WindowFunction {

    public Signal evaluateFunction(Signal signalIn) {

        final double a0 = 0.355758, a1=0.487396, a2=0.144232, a3=0.012604;
        Signal signalOut = new Signal();
        Double[] outarr = new Double[signalIn.getData().size()];
        int dimension = signalIn.getData().size();
        for (int i = 0; i < dimension; i++) {
            outarr[i] = (double)signalIn.getData().toArray()[i]*(a0-a1*Math.cos((2*Math.PI*i)/(dimension-1))+a2*Math.cos((4*Math.PI*i)/(dimension-1))-a3*Math.cos((6*Math.PI*i)/(dimension-1)));
        }

        signalOut.setData(Arrays.asList(outarr));

        return signalOut;
    }
}
