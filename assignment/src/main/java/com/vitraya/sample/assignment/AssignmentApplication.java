package com.vitraya.sample.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vitraya.sample.assignment.dl.StudentService;
import com.vitraya.sample.assignment.pojo.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;
@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean
	public Map<Integer,Student>   getStudents()
	{
			Map<Integer,Student>  studentMap=new HashMap<>();
			Student s;
			try(PreparedStatement preparedStatement=getConnection().prepareStatement("select * from student"))
			{
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					s=new Student(resultSet.getInt("roll_number"),resultSet.getString("name"),resultSet.getString("address"));
					studentMap.put(s.getRollNumber(),s);
				}
	
			}catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
	
			return studentMap;

	}



	@Bean
	public Connection getConnection()
	{
		
		Connection connection = null;
		try{

		   Class.forName("org.postgresql.Driver");
		   connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "root");
		} catch (SQLException sqlException) 
		{
		   sqlException.printStackTrace();
		}
		catch(ClassNotFoundException classNotFoundException)
		{
			classNotFoundException.printStackTrace();
		}

	return connection;	
	}


	@Bean
	public StudentService getStudentService()
	{
		return new StudentService();
	}


}
