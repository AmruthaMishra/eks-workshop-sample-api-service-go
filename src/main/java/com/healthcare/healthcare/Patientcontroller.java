package com.healthcare.healthcare;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Patientcontroller {

	private static final Logger LOGGER = LoggerFactory.getLogger(Patientcontroller.class);

	@Autowired
	PatientRepository repository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save patient in the db.
	 * @param
	 * @return
	 */
	@PostMapping(value= "/patient",produces= MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Patient patient) {
		repository.save(patient);
		LOGGER.info("Storing customer in database {}", patient);
	}

	/**
	 * Method to fetch all patients from the db.
	 * @return
	 */
	@GetMapping(value= "/getall", produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Patient> getAll() {
		final List<Patient> patients = repository.findAll();
		LOGGER.info("Fetching customers from database {}" , patients);
		return patients;
	}

	 /**
     * Method to fetch employee by id.
     * @param id
     * @return
     */
    @GetMapping(value= "/patient/{patient-id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Optional<Patient> getById(@PathVariable(value= "patient-id") String id) {
        logger.debug("Getting patient with patient-id= {}.", id);
        Optional<Patient> patient =  repository.findById(id);
        return patient;
    }
    
    
	/**
	 * Method to update patient by id.
	 * @param id
	 * @param
	 * @return
	 */
	@PutMapping(value= "/update/{patient-id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable(value= "patient-id") int id, @RequestBody Patient p) {
		logger.debug("Updating patient with patient-id= {}.", id);
		repository.save(p);
	}

	/**
	 * Method to delete patient by id.
	 * @param id
	 * @return
	 */
	@DeleteMapping(value= "/delete/{patient-id}")
	public void delete(@PathVariable(value= "patient-id") String id) {
		logger.debug("Deleting patient with patient-id= {}.", id);
		repository.deleteById(id);
	}
}
