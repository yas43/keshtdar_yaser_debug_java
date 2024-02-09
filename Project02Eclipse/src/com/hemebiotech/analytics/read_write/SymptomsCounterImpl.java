package com.hemebiotech.analytics.read_write;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class SymptomsCounterImpl implements SymptomCounter{
    @Override
    public Map<String, Long> countSymptoms(List<String> list) {
       Map<String,Long> map  = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new TreeMap<>(map);

    }
}
