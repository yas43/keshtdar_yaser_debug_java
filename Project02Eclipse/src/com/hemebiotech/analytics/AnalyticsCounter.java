package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("keshtdar_yaser_debug_java/Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		List<String>list = new LinkedList<>();
		while (line != null) {
			/*i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}*/
			list.add(line);


			line = reader.readLine();	// get another symptom
		}

		Map<String,Long> map =list
				.stream()
				.sorted()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		/*.collect(Collectors.groupingByConcurrent())*/
		/*  .forEach((k,v)-> );*/
		/*for (var entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}*/

		System.out.println(map);

		System.out.println(map.get("tremor"));


		/*System.out.println("headache: " + headacheCount + "\n"+
				"rash: " + rashCount + "\n"+
				"dialated pupils: " + pupilCount + "\n"
		);*/

		/*System.out.println(list);*/
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		/*writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");*/


		writer.write("headache: " + map.get("headache") + "\n");

		writer.close();
	}
}
