package com.signal;
import com.signal.entities.Complex;
import com.signal.entities.Signal;
import com.signal.generator.*;
import com.signal.processing.*;
import com.signal.processing.windowfunctions.HammingWindowFunction;
import com.signal.processing.windowfunctions.HannWindowFunction;
//import com.signal.processing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Signal signal;
        BaseSignalGenerator signalGenerator = new SinusSignalGenerator();
        signal = signalGenerator.perform(9000,200,100,300);

        String fileName = "sin.txt";
        writeToFile(signal, fileName);


        signalGenerator = new CosineSignalGenerator();
        signal = signalGenerator.perform(9000,200,100,300);
        fileName = "cos.txt";
        writeToFile(signal,fileName);


        signalGenerator = new SawSignalGenerator();
        signal = signalGenerator.perform(9000,200,100,300);
        fileName = "saw.txt";
        writeToFile(signal,fileName);

        signalGenerator = new RectangleSignalGenerator();
        signal = signalGenerator.perform(9000,200,100,300);
        fileName = "rectangle.txt";
        writeToFile(signal,fileName);

        signalGenerator = new ConstantSignalGenerator();
        signal = signalGenerator.perform(9000,200,100,0);
        fileName = "constant.txt";
        writeToFile(signal,fileName);

        BaseWindowSignalGenerator windowSignalGenerator = new HammingWindowSignalGenerator();
        signal = windowSignalGenerator.perform(5000,200,20);
        fileName = "hamming.txt";
        writeToFile(signal,fileName);

        signalGenerator = new SinusSignalGenerator();
        signal = signalGenerator.perform(9000,200,100,300);
        fileName = "sinDft.txt";
        writeToFile(signal,fileName);
        BaseProcessing processing = new DFT();
        WindowFunction windowFunction = new HammingWindowFunction();
        ProcessingResult processingResult = processing.performForward(signal, windowFunction);
        List<Double> reals = new ArrayList();
        List<Double> images = new ArrayList();
        for(Complex c:processingResult.getResult()) {
            reals.add(c.getReal());
            images.add(c.getImage());
        }



        signal.setData(reals);
        fileName = "sinDftReals.txt";
        writeToFile(signal,fileName);
        signal.setData(images);
        fileName = "sinDftImages.txt";
        writeToFile(signal,fileName);

        signal = processing.performReverse(processingResult);
        fileName = "sinDftReverse.txt";
        writeToFile(signal,fileName);

        /*signalGenerator = new SawSignalGenerator();
        signal = signalGenerator.perform(9000,200,100,300);
        fileName = "saw1.txt";
        writeToFile(signal,fileName);
        processing = new DFT();
        windowFunction = new HannWindowFunction();
        processingResult = processing.performForward(signal,windowFunction);
        reals = new ArrayList();
        images = new ArrayList();

        for(Complex c :processingResult.getResult()) {
            reals.add(c.getReal());
            images.add(c.getImage());
        }
        signal.setData(reals);
        fileName = "sawSignalDftReals.txt";
        writeToFile(signal,fileName);
        signal.setData(images);
        fileName = "sawSignalDftImages.txt";
        writeToFile(signal,fileName);

        signal = processing.performReverse(processingResult);
        fileName = "sawDftReverse.txt";
        writeToFile(signal,fileName);
*/

        signalGenerator = new SinusSignalGenerator();
        signal = signalGenerator.perform(10000,1000,20000,800);
        fileName = "sin800.txt";
        writeToFile(signal,fileName);
    }

    private static void writeToFile(Signal signal, String fileName) {
        FileWriter fileWriter = null;
        try {
            File sinFile = new File(fileName);
            fileWriter = new FileWriter(sinFile);
            for (int i = 0; i < signal.getData().size(); i++) {
                fileWriter.append(String.format("%d %s\n", i, signal.getData().toArray()[i].toString()));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
