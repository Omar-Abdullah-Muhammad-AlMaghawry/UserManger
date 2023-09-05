package com.zfinance.enums;

public enum FileStatusEnum {
	APPROVED("APPROVED"), DECLINED("DECLINED"), PENDING("PENDING");

	private String code;

	private FileStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
