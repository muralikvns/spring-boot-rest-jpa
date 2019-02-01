package com.example.project.springbootrestjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<?> getHello() throws Exception {
	        String msg= "Hello";
	        return new ResponseEntity(msg, HttpStatus.OK);
	        
	}
    
	@RequestMapping(value = "/hospitals/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getHospital(@PathVariable("id") Long id) throws Exception {
	        Hospital hospital = hospitalService.getHospital(id);
	        return new ResponseEntity(hospital, HttpStatus.OK);
	        
	}

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)
	public ResponseEntity<?> getAllHospitals() {
        List hospitalDetails = hospitalService.getAllHospitals();
		return new ResponseEntity(hospitalDetails, HttpStatus.OK);
	}

    @RequestMapping(value = "/hospitals" ,method = RequestMethod.POST)
	public ResponseEntity<?> addHospital(@RequestBody Hospital hospital) {
    	System.out.println("add hospital begin");
    	Hospital hospitalDetails = hospitalService.addHospital(hospital);
    	System.out.println("add hospital end");
		return new ResponseEntity(hospitalDetails, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/hospitals/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateHospital(Long id,@RequestBody Hospital hospital) {
    		Hospital hospitalDetails=hospitalService.updateHospital(id, hospital);
    		return new ResponseEntity(hospitalDetails, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/hospitals/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    	hospitalService.deleteHospital(id);
        return new ResponseEntity("success", HttpStatus.NO_CONTENT);
    }
}
