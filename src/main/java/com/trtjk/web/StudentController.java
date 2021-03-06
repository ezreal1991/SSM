package com.trtjk.web;


import com.trtjk.beans.Student;
import com.trtjk.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class StudentController {

    @Autowired
    @Qualifier("studentService")
	private IStudentService service;

	public void setService(IStudentService service) {
		this.service = service;
	}

	@RequestMapping("/register")
	public ModelAndView handleRequest(Student student) {



		service.addStudent(student);

		ModelAndView m = new ModelAndView();
		m.addObject("userName", student.getName());
		m.setViewName("/index1.jsp");
		return m;
	}

}
