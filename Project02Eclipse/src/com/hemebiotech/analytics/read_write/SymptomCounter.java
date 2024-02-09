package com.hemebiotech.analytics.read_write;

import java.util.*;

public interface SymptomCounter {
    Map<String,Long> countSymptoms(List<String> list);
}
