package org.dnynyog.service;

import java.util.Optional;

import org.dnynyog.dto.DeleteAppointmentResponce;
import org.dnynyog.model.Appoinment;
import org.dnynyog.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteAppointmentService {
	
	@Autowired
	AppointmentRepo repo;
	
	public DeleteAppointmentResponce deleteAppointment(Integer appointmentId)
	{
		DeleteAppointmentResponce responce=new DeleteAppointmentResponce();
		Optional<Appoinment> checkAppointment=repo.findById(appointmentId);
		if(checkAppointment.isPresent())
		{
			repo.deleteById(appointmentId);
			responce.setResponceCode("0000");
			responce.setMessage("delete appointment successfully");
			return responce;
		}
		else
		{
			responce.setResponceCode("9111");
			responce.setMessage("delete appointment failed");
			return responce;
		}
	}
}
