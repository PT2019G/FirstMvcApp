package org.techhub.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.techhub.model.Login;
import org.techhub.model.Register;
import org.techhub.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationRepository registrationRepository;
	@Override
	public boolean saveRegistrationData(Register register,MultipartFile photo) {
		// TODO Auto-generated method stub
		boolean b=registrationRepository.saveRegistration(register,photo);
		return b;
	}

	@Override
	public List<Register> getDetails(String username) {
		// TODO Auto-generated method stub
		List<Register> ls=registrationRepository.getDetails(username);
		return ls;
	}

	public Blob getPhotoById(int id) {
		// TODO Auto-generated method stub
		return registrationRepository.getPhotoById(id);
	}

	public boolean validateUsernameAndPassword(Login login) {
		return registrationRepository.validateUsernameAndPassword(login);
		
	}

	

}
