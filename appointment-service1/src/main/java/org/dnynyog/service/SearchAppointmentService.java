package org.dnynyog.service;

import java.util.Optional;

import org.dnynyog.model.Appoinment;
import org.dnynyog.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchAppointmentService {

	@Autowired
	AppointmentRepo repo;
	
	public Optional<Appoinment> getSingleAppointment(Integer appointmentId,Integer patientId)
	{
		return Optional.ofNullable(repo.findByAppointmentIdAndPatientId(appointmentId, patientId));
	}
}
