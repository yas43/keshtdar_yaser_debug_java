package com.hemebiotech.analytics.read_write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {
	private Map<String,Long> map;
	String filename;



	public WriteSymptomDataToFile(String filename) {
		this.filename = filename;
	}


	@Override
	public void WriteSymptoms(Map<String,Long> map) throws IOException {


		FileWriter writer = new FileWriter (filename);

		writer = new FileWriter(filename);
		for (var entry : map.entrySet()) {

			writer.write(String.valueOf(entry)+ "\n");
			/*System.out.println(entry.getKey() + "/" + entry.getValue());*/
		}

		writer.close();

	}

}
