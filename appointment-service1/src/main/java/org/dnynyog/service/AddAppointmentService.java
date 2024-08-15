package org.dnynyog.service;

import java.util.Optional;

import org.dnynyog.dto.AddAppointmentRequest;
import org.dnynyog.dto.AddAppointmentResponce;
import org.dnynyog.model.Appoinment;
import org.dnynyog.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddAppointmentService {

	@Autowired
	AppointmentRepo repo;
	
	public AddAppointmentResponce addAppointment(AddAppointmentRequest request)
	{
		AddAppointmentResponce responce=new AddAppointmentResponce();
		Appoinment appointmentTable=new Appoinment();
		appointmentTable.setPatientName(request.getPatientName());
		appointmentTable.setPatientId(request.getPatientId());
		appointmentTable.setExamDate(request.getExamDate());
		appointmentTable.setAppointmentTime(request.getAppointmentTime());
		appointmentTable=repo.save(appointmentTable);
		Optional<Appoinment> checkAppointment =repo.findByPatientNameAndPatientId(request.getPatientName(), request.getPatientId());
		if(checkAppointment.isPresent())
		{
			responce.setResponceCode("0000");
			responce.setMessage("appointment addition successfully");
			responce.setAppointmentId(appointmentTable.getPatientId());
			responce.setRequest(request);
			return responce;
			
		}
		else
		{
			responce.setResponceCode("9111");
			responce.setMessage("appointment addition failed");
			return responce;
		}
	}
}
