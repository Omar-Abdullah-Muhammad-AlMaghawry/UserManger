package com.zfinance.enums;

public enum StatusEnum {
	APPROVED("approved"), DECLINED("declined"), PENDING("pending"), NONE("none");

	private String code;

	private StatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
