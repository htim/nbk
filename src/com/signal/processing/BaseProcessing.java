package com.signal.processing;

import com.signal.entities.Signal;

/**
 * Created by htim on 30.10.14.
 */
public interface BaseProcessing {

    public ProcessingResult performForward(Signal signal, WindowFunction windowFunction);
    public Signal performReverse(ProcessingResult processingResultIn);
}
