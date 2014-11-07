package com.signal.processing;

import com.signal.entities.Complex;

import java.util.List;

/**
 * Created by htim on 31.10.14.
 */
public class ProcessingResult {

    private List<Complex> result;

    public ProcessingResult(List<Complex> result) {
        this.result = result;
    }

    public List<Complex> getResult() {
        return result;
    }
}
