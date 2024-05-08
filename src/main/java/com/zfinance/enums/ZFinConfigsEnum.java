package com.zfinance.enums;

public enum ZFinConfigsEnum {
	FRONT_END_URL("FRONT_END_URL");

	private String code;

	private ZFinConfigsEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
