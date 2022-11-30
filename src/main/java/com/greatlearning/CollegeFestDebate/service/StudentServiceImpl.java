package com.greatlearning.CollegeFestDebate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.CollegeFestDebate.entity.Student;
import com.greatlearning.CollegeFestDebate.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {

		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);

	}

	@Override
	public List<Student> searchBy(String firstname, String country) {
		List<Student> students = studentRepository.findByNameContainsAndCountryContainsAllIgnoreCase(firstname,country);
		return students;
	}

}
