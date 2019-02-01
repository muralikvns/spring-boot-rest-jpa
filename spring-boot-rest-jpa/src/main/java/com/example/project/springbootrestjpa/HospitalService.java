package com.example.project.springbootrestjpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> getAllHospitals(){
		List<Hospital> hospitalList= new ArrayList<Hospital>();
		hospitalRepository.findAll().forEach(hospitalList::add);
		return hospitalList;
		}
		
	public Hospital addHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);	
	}
	
	public Hospital getHospital(Long id){
		return hospitalRepository.findById(id).orElseThrow(HospitalNotFoundException::new);
	}
	
	public Hospital updateHospital(Long id,Hospital hospitalDetails) {
		
		Hospital hospital = hospitalRepository.findById(id).orElseThrow(HospitalNotFoundException::new);
	    hospital.setName(hospitalDetails.getName());
		hospital.setRating(hospitalDetails.getRating());
		hospital.setCity(hospitalDetails.getCity());
        Hospital updatedHospital = hospitalRepository.save(hospital);

		return updatedHospital;
		
	}
	
	public void deleteHospital(Long id) {
		 hospitalRepository.deleteById(id);
	}

}
