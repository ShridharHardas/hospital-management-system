package org.dnynyog.controller;

import java.util.Optional;

import org.dnynyog.dto.AddAppointmentRequest;
import org.dnynyog.dto.AddAppointmentResponce;
import org.dnynyog.dto.DeleteAppointmentResponce;
import org.dnynyog.dto.UpdateAppointmentRequest;
import org.dnynyog.dto.UpdateAppointmentResponce;
import org.dnynyog.model.Appoinment;
import org.dnynyog.service.AddAppointmentService;
import org.dnynyog.service.DeleteAppointmentService;
import org.dnynyog.service.SearchAppointmentService;
import org.dnynyog.service.UpdateAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

	@Autowired
	AddAppointmentService addAppointmentService;
	@PostMapping(path="/api/v1/appointment/add")
	public AddAppointmentResponce addAppointment(@RequestBody AddAppointmentRequest request)
	{
		return addAppointmentService.addAppointment(request);
	}
	
	@Autowired
	DeleteAppointmentService deleteAppointmentService;
	@DeleteMapping(path ="/api/v1/appointment/{appointmentId}")
	public DeleteAppointmentResponce deleteAppointment(@PathVariable Integer appointmentId)
	{
		return deleteAppointmentService.deleteAppointment(appointmentId);
	}
	
	@Autowired
	SearchAppointmentService searchAppointmentService;
	@GetMapping(path ="/api/v1/appointment/{appointmentId}/{patientId}"
)
	public Optional<Appoinment> getSingleAppointment(@PathVariable Integer appointmentId,@PathVariable Integer patientId)
	{
		return searchAppointmentService.getSingleAppointment(appointmentId, patientId);
	}
	
	@Autowired
	UpdateAppointmentService updateAppointmentService;
	@PostMapping(path="/api/v1/appointment/update")
	public UpdateAppointmentResponce updateAppointment(@RequestBody UpdateAppointmentRequest request)
	{
		return updateAppointmentService.updateAppointment(request);
	}
}
