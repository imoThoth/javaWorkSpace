package com.titans.atlas.service;

import com.titans.atlas.model.Student;
import com.titans.atlas.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> studentList(){

		return studentRepository.findAll();
//		return List.of(
//				new Student(1L, "Agenor", 29,
//						LocalDate.of(1923, Month.APRIL, 6),
//						"agenor@greek.arcne.com")
//		);
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
			if(studentEmail.isPresent()){
				throw new IllegalArgumentException("email taken");
			}
			studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		Optional<Student> deleteID = studentRepository.findById(id);

		if(deleteID.isPresent()){
			studentRepository.deleteById(id);
		} else{
			throw new IllegalArgumentException("Id does not exist");
		}
	}

	@Transactional
	public void updateStudent(Long studentID, String name, String email) {

		Student student = studentRepository.findById(studentID).orElseThrow(() ->
				new IllegalArgumentException(
						"student id " + studentID + " does not exist"
				));

		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
			student.setName(name);
		}

		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if(studentOptional.isPresent()){
				throw new IllegalArgumentException("Email Taken");
			}
			student.setEmail(email);
		}
	}

}
