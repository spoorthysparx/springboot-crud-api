package com.hexaware.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.Dao.StudentRepository;
import com.hexaware.web.Entity.Student;
import com.hexaware.web.Exception.IdNotFoundException;

@Service
public class StudentService {
	@Autowired
	StudentRepository studrep;
	
		public int  updateInfo(double fee, int roll)
	{
		 
		int k=studrep.updaleBal(fee, roll);

		return k;
	}
		
		public List<Student> FindDataByName(String name)
		{
			List<Student>lis= studrep.findByNameContaining(name);
			if(lis.isEmpty())
			{
				 throw new IdNotFoundException("Student(s) not found with name: " + name);
				
			}
			return lis;
		}
		
		
		public List<Student> FindDataByAge(int age1,int age2)
		{
			List<Student>lis= studrep.findByAgeBetween(age1, age2);
			if(lis.isEmpty())
			{
				 throw new IdNotFoundException("Student(s) not found with name: " + age1+" "+age2);
				
			}
			return lis;
		}
	
		public Student  saveStud(Student s)
	
	{	
		int roll = s.getRoll();
		System.out.println(roll);
		System.out.println(studrep.findById(roll).isEmpty());
		if(studrep.findById(roll).isEmpty()==false) 
		{
			
			return null;
		}
		else {
			Student s2=studrep.save(s);
			return s2;
		}
	}

		public List<Student> getStud() {
			List<Student> l = (List) studrep.findAll();
			return l;
		}

		public Student removeStud(int rollNm) {
			Student s = studrep.findById(rollNm).orElse(null);
			if(s==null) {
				return null;
			}
			else {
				studrep.delete(s);
			}
			return s;
		}

		public String updateStud(int rollNm, String newName) {
			Student s = studrep.findById(rollNm).orElse(null);
			if(s==null) {
				return null;
			}
			else {
				s.setName(newName);
				studrep.save(s);
				return "Name updated";
			}

		}

		public String getStudNameById(int rollNm) {
			Student s = studrep.findById(rollNm).orElse(null);
			if(s==null) {
				return "Student not found";
			}
			else {
				return s.getName();
			}
		}

		public Student getStudById(int rollNm) {
			
			Student s = studrep.findById(rollNm).orElseThrow(()->new IdNotFoundException("not found "+ rollNm));
			if(s==null) {return null;}
			else{return s;}
			
		}
}
