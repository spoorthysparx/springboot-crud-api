package com.hexaware.web.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.web.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Modifying

	@Query(value="update Student set fee=:fee where Roll=:roll",nativeQuery=true)

	public int updaleBal(@Param("fee") double b, @Param("roll")int a);

	 List<Student> findByNameContaining(String name);	
	 
	 List<Student> findByAgeBetween(int age1,int age2);
}
