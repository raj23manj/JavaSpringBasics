package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestCOntroller {
	
	private List<Student> theStudents;
	
	// using beans @PostConstruct to load data once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rasi"));
		theStudents.add(new Student("Mary", "Smith"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId >= theStudents.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student Id not FOund - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	// inline
	
//	// Add an exception handler using @ExceptionHandler
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//	
//	// Add another exception handler .... to catch any exception (catch all)
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
	
}
