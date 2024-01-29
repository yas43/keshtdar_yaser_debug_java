package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {
    ISymptomReader reader;
    ISymptomWriter writer;


    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
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
        return map;
    }


    public Map<String, Long> sortSymptoms(Map<String, Long> symptoms) {
        symptoms
                .entrySet()
                .stream()
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return symptoms;

    }


    public void writeSymptoms(Map<String, Long> symptoms) throws IOException {
        writer.WriteSymptoms(symptoms);
    }
}
