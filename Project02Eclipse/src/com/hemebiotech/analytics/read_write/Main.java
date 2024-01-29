package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ISymptomWriter symptomWriter;
        ISymptomReader symptomReader;
        AnalyticsCounter analyticsCounter;

        symptomReader = new ReadSymptomDataFromFile("keshtdar_yaser_debug_java/Project02Eclipse/symptoms.txt");
        symptomWriter = new WriteSymptomDataFromFile("result.out_test2");
        analyticsCounter = new AnalyticsCounter(symptomReader,symptomWriter);
        List<String> list = analyticsCounter.getSymptoms();
        Map<String,Long> counted_map = analyticsCounter.countSymptoms(list);
        Map<String,Long> sorted_map = analyticsCounter.sortSymptoms(counted_map);
        symptomWriter.WriteSymptoms(sorted_map);


    }
}
