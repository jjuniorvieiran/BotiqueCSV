package com.br.farfetch.botique.service;

import static com.br.farfetch.botique.util.BotiqueUtils.getListFromCSVFile;
import static com.br.farfetch.botique.util.BotiqueUtils.displayOrderCharged;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.br.farfetch.botique.model.entity.Order;

public class BotiqueServiceImpl implements BotiqueService{

	@Override
	public void processOrder( String input) {
		
		List<Order> listOrder = getListFromCSVFile(input).stream().sorted(Comparator.comparingDouble(Order::getValue)).collect(Collectors.toList());
		
		/**
		 * Requirement 1: The order with the highest value of the day will not be subject to commission
		 */
		listOrder.remove(listOrder.size()-1);
		listOrder = listOrder.stream().sorted(Comparator.comparing(Order::getName)).collect(Collectors.toList());
		
		displayOrderCharged(listOrder);
		
	}

	
	
}
