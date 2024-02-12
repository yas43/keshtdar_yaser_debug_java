package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application {

    public static final String SYMPTOMS_FILE = "symptoms.txt";
    public static final String RESULT_OUT_FILE = "result_out.txt";

    static SymptomReader symptomReader  = new ReadSymptomDataFromFileImp(SYMPTOMS_FILE);


    static SymptomCounter symptomsCounter = new SymptomsCounterImpl();


    static SymptomWriter symptomWriter = new WriteSymptomDataToFileImp(RESULT_OUT_FILE);
    static AnalyticsCounter analyticsCounterImp = new AnalyticsCounterImp(symptomReader, symptomsCounter, symptomWriter);

    public static void main(String[] args) throws IOException {

        List<String> list = analyticsCounterImp.getSymptoms(); //read the file and save it as a list

        Map<String,Long> counted_map = analyticsCounterImp.countSymptoms(list);//take a list  as parameters and count occurrence for every item
                                                                                // and sort it and return result over a map

        analyticsCounterImp.writeSymptoms(counted_map); // write a map line by line and save it a file






    }
}
