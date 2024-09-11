package com.hexaware.web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.web.Entity.Student;
import com.hexaware.web.Service.StudentService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class StudentController {
	@Autowired
	StudentService studser;
	
	@PostMapping("/saveStudent")
	ResponseEntity<Student> saveStudent( @Valid @RequestBody Student s)
	{
		
			Student s2=studser.saveStud(s);
			
			if(s2==null) {
 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
 
			else {
 
				return new ResponseEntity<>(s2,HttpStatus.CREATED);
        }
		
    }
	
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getStudent() {
		List <Student> users = studser.getStud();
		
		if(users.size()!=0) {
			return new ResponseEntity<>(users, HttpStatus.OK);}
		
		else {
			return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/removeStudent/{rollNm}")
	public Student removeStudent(@PathVariable int rollNm) {
		Student s = studser.removeStud(rollNm);
		return s;
	}
	
//	@PutMapping("/updateStudentName/{rollNm}/{NewName}")
//	public ResponseEntity<String> updateStudent(@PathVariable int rollNm,@PathVariable String NewName) {
//		
//		
//			String s = studser.updateStud(rollNm,NewName);
//			
//			if(s==null) {
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
//			else {
//            return new ResponseEntity<>(s, HttpStatus.OK);}
//	}
	
	@GetMapping("/getStudentName/{rollNm}")
	public ResponseEntity<String> getStudentNameById(@PathVariable int rollNm) {
		try {
            String student = studser.getStudNameById(rollNm);
 
            return new ResponseEntity<>(student, HttpStatus.OK);
 
        } catch (RuntimeException e) {
 
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
		
		
    }
	
	
	@GetMapping("/getStudent/{rollNm}")
	
	public ResponseEntity<Student> getStudentById(@PathVariable int rollNm) {
        try {
            Student student = studser.getStudById(rollNm);
 
            return new ResponseEntity<>(student, HttpStatus.OK);
 
        } catch (RuntimeException e) {
 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@Transactional

	 @PutMapping("/updatedatabyq/{fee}/{roll}")

	 public  String updateData1( @PathVariable double  fee,  @PathVariable int  roll ){

		String msg="";

		 int k=  studser.updateInfo(fee,roll);

		 if(k>=1)

		 {

			 msg="Updated";

		 }

		 else

		 {

			 msg="not updated";

		 }

		 return (msg);

	 }
	
	@GetMapping("/getDataByName/{name}")
	public ResponseEntity<List<Student> >getDataByName(@PathVariable  String name )
	{
		List<Student> list=studser.FindDataByName(name);
		if( list.isEmpty()
				)
		{
			return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
	}
	
	@GetMapping("/getDataByAge/{age1}/{age2}")
	public ResponseEntity<List<Student> >getagebetween(@PathVariable  int age1 ,@PathVariable  int age2)
	{
		List<Student> list=studser.FindDataByAge(age1, age2);
		if( list.isEmpty()
				)
		{
			return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
	}
}
