package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application {

    public static final String SYMPTOMS_FILE = "symptoms.txt";
    public static final String RESULT_OUT_FILE = "result_test.out";


    static ISymptomReader symptomReader  = new ReadSymptomDataFromFile(SYMPTOMS_FILE);
    static ISymptomWriter symptomWriter = new WriteSymptomDataToFile(RESULT_OUT_FILE); // Todo : it's WriteSymptomDataToFile
    static AnalyticsCounterImp analyticsCounterImp = new AnalyticsCounterImp(symptomReader,symptomWriter); // Todo : !! create an interface

    public static void main(String[] args) throws IOException {

        List<String> list = analyticsCounterImp.getSymptoms(); //read the file and save it in a list

        Map<String,Long> counted_map = analyticsCounterImp.countSymptoms(list);//take file as a list and count occurrence for every item over a map

        analyticsCounterImp.writeSymptoms(counted_map);

    }
}
