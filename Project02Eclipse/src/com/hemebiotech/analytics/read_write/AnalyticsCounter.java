package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AnalyticsCounter {

    List<String> getSymptoms();

    Map<String, Long> countSymptoms(List<String> symptoms);

    void writeSymptoms(Map<String, Long> symptoms) throws IOException;
}
