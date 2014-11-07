package com.signal.processing;

import com.signal.entities.Signal;

/**
 * Created by htim on 30.10.14.
 */
public interface WindowFunction {

    public Signal evaluateFunction(Signal signalIn);
}
