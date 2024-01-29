package com.hemebiotech.analytics.read_write;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface ISymptomWriter {

	void WriteSymptoms(Map<String,Long> map) throws IOException;
}
