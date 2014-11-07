package com.signal.processing;

import com.signal.entities.Complex;
import com.signal.entities.Signal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by htim on 30.10.14.
 */
public class DFT implements BaseProcessing {

    @Override
    public ProcessingResult performForward(Signal signalIn, WindowFunction windowFunction) {

        int dimension = signalIn.getData().size();
        
        Signal signalAfterWindowFunction = windowFunction.evaluateFunction(signalIn);
        List<Complex> processingResultData = new ArrayList();

        for (int i = 0; i < dimension; i++) {
            Double sumReal=0.0, sumImage = 0.0;
            for (int j = 0; j < dimension; j++) {
                Double angle = 2 * Math.PI * j * i / dimension;
                sumReal += signalAfterWindowFunction.getData().get(j) * Math.cos(angle);
                sumImage += -signalAfterWindowFunction.getData().get(j) * Math.sin(angle);
            }
            Complex out = new Complex(sumReal,sumImage);
            processingResultData.add(out);
        }

        ProcessingResult processingResultInstance = new ProcessingResult(processingResultData);
        return processingResultInstance;
    }

    @Override
    public Signal performReverse(ProcessingResult processingResult) {

        Signal signalInstance = new Signal();
        List<Complex> complexData = processingResult.getResult();
        int dimension = complexData.size();
        Double[] samples = new Double[dimension];

        for (int i = 0; i < dimension; i++) {

            Double tmp = 0.0;
            for (int j = 0; j < dimension; j++) {
                Double angle = 2*Math.PI*j*i/dimension;
                 tmp += complexData.get(j).getReal()*Math.cos(angle)-complexData.get(j).getImage()*Math.sin(angle);
            }
            samples[i] = 1.0/processingResult.getResult().size()*tmp;
        }

        signalInstance.setData(Arrays.asList(samples));
        return signalInstance;
    }

}
