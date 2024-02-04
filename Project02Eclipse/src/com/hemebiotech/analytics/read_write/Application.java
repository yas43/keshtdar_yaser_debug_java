package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application {

    public static final String SYMPTOMS_FILE = "symptoms.txt";
    public static final String RESULT_OUT_FILE = "result_test.txt";


    static SymptomReader symptomReader  = new ReadSymptomDataFromFileImp(SYMPTOMS_FILE);
    static SymptomWriter symptomWriter = new WriteSymptomDataToFileImp(RESULT_OUT_FILE); // Todo : it's WriteSymptomDataToFile
    static AnalyticsCounterImp analyticsCounterImp = new AnalyticsCounterImp(symptomReader,symptomWriter); // Todo : !! create an interface
    public static void main(String[] args) throws IOException {

        List<String> list = analyticsCounterImp.getSymptoms(); //read the file and save it in a list

        Map<String,Long> counted_map = analyticsCounterImp.countSymptoms(list);//take file as a list and count occurrence for every item over a map

        analyticsCounterImp.writeSymptoms(counted_map);




/*AnalyticsCounter obj = new AnalyticsCounterImp(symptomReader,symptomWriter);*/


    }
}
