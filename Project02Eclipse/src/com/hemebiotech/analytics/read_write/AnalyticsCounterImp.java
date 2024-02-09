package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounterImp implements AnalyticsCounter {
    private final SymptomReader reader;
    private final SymptomCounter counter;
    private final SymptomWriter writer;


     public AnalyticsCounterImp(SymptomReader reader, SymptomCounter counter, SymptomWriter writer) {
        this.reader = reader;
        this.counter = counter;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.GetSymptoms();

    }

     /*move to a new class SymptomCounter*/
    public Map<String, Long> countSymptoms(List<String> symptoms) {

        return counter.countSymptoms(symptoms);
    }


    public void writeSymptoms(Map<String, Long> symptoms) throws IOException {
        writer.WriteSymptoms(symptoms);
    }
}
