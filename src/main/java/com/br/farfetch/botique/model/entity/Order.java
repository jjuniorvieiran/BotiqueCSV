package com.br.farfetch.botique.model.entity;

/**
 * @author Admin
 *
 */
public class Order {
	
	private String name;
	private String code;
	private Double value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", code=" + code + ", value=" + value
				+ "]";
	}
	
	

}
