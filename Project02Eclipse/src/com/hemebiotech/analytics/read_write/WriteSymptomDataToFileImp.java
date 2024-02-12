package com.hemebiotech.analytics.read_write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class WriteSymptomDataToFileImp implements SymptomWriter {
	private final String filename;

	public WriteSymptomDataToFileImp(String filename) {
		this.filename = filename;
	}

	@Override
	public void writeSymptoms(Map<String,Long> map) throws IOException {


		FileWriter writer = new FileWriter(filename);
		for (var entry : map.entrySet()) {

			writer.write(entry + "\n");

		}

		writer.close();

	}

}
