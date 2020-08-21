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
	public Register getDetails(String username) {
		// TODO Auto-generated method stub
		Register r=registrationRepository.getDetails(username);
		return r;
	}

	public Blob getPhotoById(int id) {
		Blob photo=registrationRepository.getPhotoById(id);;
		return photo;
	}

	public boolean validateUsernameAndPassword(Login login) {
		boolean b=registrationRepository.validateUsernameAndPassword(login);
		return b;
		
	}

	

}
