package org.techhub.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.techhub.model.Login;
import org.techhub.model.Register;
import org.techhub.service.RegistrationServiceImpl;

@Controller
public class TestCon {

	@Autowired
	RegistrationServiceImpl registrationService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute Login login,Map map) {
		System.out.println("Username=" + login.getUsername());
		
		boolean validateUsernameAndPassword = registrationService.validateUsernameAndPassword(login);
		if(validateUsernameAndPassword) {
			map.put("username", login.getUsername());
			return "welcome";
		}
		/*
		 * if (login.getUsername().equals("Pooja")) { return "welcome"; }
		 */
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationPage() {
		return "registration";
	}

	@RequestMapping(value = "/submitregistrationdata", method = RequestMethod.POST)
	public String submitRegistrationData(@ModelAttribute Register register, BindingResult bindingResult,
			@RequestParam("photo") MultipartFile photo) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError());
			return "registration";

		}
		Boolean b = registrationService.saveRegistrationData(register,photo);

		if (b) {
			return "login";
		}
		return "registration";

	}

	@RequestMapping(value = "/viewDetails/{username}", method = RequestMethod.GET)
	public String viewDetails(@PathVariable("username") String username,Map map) {
		List<Register> details = registrationService.getDetails(username);
		map.put("regList", details);
		for (Register register : details) {
			System.out.println(register.getName());
		}
		return "profile";
	}
	
	@RequestMapping(value = "/getStudentPhoto/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		Blob ph = registrationService.getPhotoById(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	

}
