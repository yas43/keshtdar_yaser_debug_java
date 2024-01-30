package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {
    ISymptomReader reader;
    ISymptomWriter writer;


    public AnalyticsCounterImp(ISymptomReader reader, ISymptomWriter writer) {
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
