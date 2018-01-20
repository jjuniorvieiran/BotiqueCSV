package com.br.farfetch.botique.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.br.farfetch.botique.model.entity.Order;

import junit.framework.TestCase;

public class BotiqueUtilsTest extends TestCase {

	@Test
	public void testGroupOrderByNameWithTwoOrder() {
		
		List<Order> listOrder = new ArrayList<Order>();
		
		Order order1B10 = new Order();
		order1B10.setCode("O1000");
		order1B10.setName("B10");
		order1B10.setValue(100.00);
		listOrder.add(order1B10);

		Order order2B10 = new Order();
		order2B10.setCode("O1000");
		order2B10.setName("B10");
		order2B10.setValue(100.00);
		listOrder.add(order2B10);
		
		Order order1B11 = new Order();
		order1B11.setCode("O1000");
		order1B11.setName("B11");
		order1B11.setValue(100.00);
		listOrder.add(order1B11);
		
		assertEquals(2, BotiqueUtils.groupOrderByName(listOrder).size());
	}
	
	@Test
	public void testGroupOrderByNameWithTwoThree() {
		
		List<Order> listOrder = new ArrayList<Order>();
		
		Order order1 = new Order();
		order1.setCode("O1000");
		order1.setName("B10");
		order1.setValue(100.00);
		listOrder.add(order1);

		Order order2 = new Order();
		order2.setCode("O1000");
		order2.setName("B11");
		order2.setValue(100.00);
		listOrder.add(order2);
		
		Order order3 = new Order();
		order3.setCode("O1000");
		order3.setName("B13");
		order3.setValue(100.00);
		listOrder.add(order3);
		
		assertEquals(3, BotiqueUtils.groupOrderByName(listOrder).size());
	}

}
