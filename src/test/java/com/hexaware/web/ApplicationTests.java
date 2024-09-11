package com.hexaware.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.web.Dao.StudentRepository;
import com.hexaware.web.Entity.Student;


@SpringBootTest
class ApplicationTests {
	@Autowired
    StudentRepository rep;
	@Test
	void saveTest()
	{
	Student p = new Student(101,"spoorthy",30000.0,26,"sp@gmail.com","chennai");
	rep.save(p);
	
	}
}

