package org.techhub.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.techhub.model.Register;

@Repository
public interface RegistrationService {
	
	public boolean saveRegistrationData(Register register,MultipartFile photo);
	Register getDetails(String username);

}
