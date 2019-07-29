package com.mybatis3.mappers;

import com.mybatis3.domain.Student;

import java.util.List;


public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	int insertStudent(Student student);

	int updateStudent(Student student);

}
