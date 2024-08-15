package org.dnynyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddAppointmentResponce {
	private Integer appointmentId;
	private String responceCode;
	private String message;
	private AddAppointmentRequest request;
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getResponceCode() {
		return responceCode;
	}
	public void setResponceCode(String responceCode) {
		this.responceCode = responceCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AddAppointmentRequest getRequest() {
		return request;
	}
	public void setRequest(AddAppointmentRequest request) {
		this.request = request;
	}
}
