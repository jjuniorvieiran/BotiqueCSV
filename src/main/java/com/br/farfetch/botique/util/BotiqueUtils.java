package com.br.farfetch.botique.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.br.farfetch.botique.model.entity.Order;

public class BotiqueUtils {

	public static List<Order> getListFromCSVFile(String input){
		
		input = input.replaceAll("OrderBatch ", "");
		CSVFormat format = CSVFormat.RFC4180.withDelimiter(',');

		List<Order> listOrder = new ArrayList<Order>();
		try {
			CSVParser parser = new CSVParser(new FileReader(input), format);
			
			for(CSVRecord row : parser){
				Order order = new Order();
				order.setName(row.get(0));
				order.setCode(row.get(1));
				order.setValue(Double.parseDouble(row.get(2)));
				listOrder.add(order);
			}
			parser.close();
			
		} catch (FileNotFoundException e) {
			// TODO Implement log4J
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Implement log4J
			e.printStackTrace();
		}
		
		return listOrder;
		
	}
	
	/**
	 * @param input
	 * @throws IOException
	 * 
	 * Implementation to handle huge File
	 * 
	 * @author José V Junior
	 */
	public static void getListFromHugeCSVFile(String input) throws IOException{
		
		LineIterator it = FileUtils.lineIterator(new File(input), "UTF-8");
		try {
		    while (it.hasNext()) {
		        String line = it.nextLine();
		        // do something with line
		    }
		} finally {
		    LineIterator.closeQuietly(it);
		}
		
	}
	
	public static void displayOrderCharged(List<Order> listOrder){
		

		/**
		 * Requirement 2: Boutiques should be charged by 10% of the total value every order
		 */
		groupOrderByName(listOrder).forEach((k,v)->System.out.println("" + k + ", " + v * 0.10));
		
	}
	
	
	public static Map<String, Double> groupOrderByName(List<Order> listOrder){
		
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 0; i < listOrder.size(); i++) {
			if(map.containsKey(listOrder.get(i).getName())){
				map.put(listOrder.get(i).getName(), map.get(listOrder.get(i).getName()) + listOrder.get(i).getValue()); 
			} else {
				map.put(listOrder.get(i).getName(),listOrder.get(i).getValue());
			}	
		}
		
		return map;
	}
	
}
