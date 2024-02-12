package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.Map;


public interface SymptomWriter {

	void writeSymptoms(Map<String,Long> map) throws IOException;
}
