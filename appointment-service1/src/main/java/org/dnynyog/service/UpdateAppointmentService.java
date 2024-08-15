package org.dnynyog.service;

import java.util.Optional;

import org.dnynyog.dto.UpdateAppointmentRequest;
import org.dnynyog.dto.UpdateAppointmentResponce;
import org.dnynyog.model.Appoinment;
import org.dnynyog.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateAppointmentService {

	@Autowired
	AppointmentRepo repo;
	
	public UpdateAppointmentResponce updateAppointment(UpdateAppointmentRequest request)
	{	
		Appoinment appointmentTable=new Appoinment();
		UpdateAppointmentResponce responce=new UpdateAppointmentResponce();
		if(request.getAppointmentId()==null)
		{
			responce.setResponceCode("9111");
			responce.setMessage("It is Mandatory to write appointment id");
			return responce;
		}
		
		Optional<Appoinment> checkAppointment=repo.findById(request.getAppointmentId());
		if(checkAppointment.isPresent())
		{
			appointmentTable.setAppointmentId(request.getAppointmentId());
			appointmentTable.setPatientName(request.getPatientName());
			appointmentTable.setPatientId(request.getPatientId());
			appointmentTable.setExamDate(request.getExamDate());
			appointmentTable.setAppointmentTime(request.getAppointmentTime());
			repo.save(appointmentTable);
			responce.setResponceCode("0000");
			responce.setMessage("update appointment successfully");
			return responce;
			
		}
		else
		{
			responce.setResponceCode("9111");
			responce.setMessage("update appointment Failed");
			return responce;
		}
	}
}
