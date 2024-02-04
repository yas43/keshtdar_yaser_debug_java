package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounterImp implements AnalyticsCounter {
    SymptomReader reader;
    SymptomWriter writer;


     public AnalyticsCounterImp(SymptomReader reader, SymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.GetSymptoms();

    }

    public Map<String, Long> countSymptoms(List<String> symptoms) {
        Map<String, Long> map = symptoms
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new TreeMap<>(map);
    }


    public void writeSymptoms(Map<String, Long> symptoms) throws IOException {
        writer.WriteSymptoms(symptoms);
    }
}
