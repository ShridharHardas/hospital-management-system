package org.dnynyog.repository;

import java.util.Optional;

import org.dnynyog.model.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppointmentRepo extends JpaRepository<Appoinment, Integer> {
	
	public Appoinment findByAppointmentIdAndPatientId(Integer appointmentId,Integer patientId);
	public Optional<Appoinment> findByPatientNameAndPatientId(String patientName,Integer patientId);
}
