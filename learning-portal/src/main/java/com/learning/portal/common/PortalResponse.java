package com.learning.portal.common;

import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class PortalResponse{
	
	private int status;
	private Boolean success;
	private String message;
	private Object data;
	
	public PortalResponse() {
		super();
	}

	public PortalResponse(int status, boolean success, String message, Object data) {
		super();
		this.status = status;
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	public PortalResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseEntity<PortalResponse> build() {
		return ResponseEntity.ok(this);
	}
}
