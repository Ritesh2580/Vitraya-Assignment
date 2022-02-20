package com.vitraya.sample.assignment.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.vitraya.sample.assignment.pojo.Student;
import com.vitraya.sample.assignment.pojo.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;


public class StudentService {

    @Autowired
    Connection connection;

    public StudentResponse add(Student student)
    {
        StudentResponse studentResponse=new StudentResponse();
    
        try(PreparedStatement preparedStatement=this.connection.prepareStatement("INSERT INTO public.student(name, address) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getAddress());
            preparedStatement.executeUpdate();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            while(resultSet.next())
            {
                student.setRollNumber(resultSet.getInt("roll_number"));
            }
        }catch(SQLException sqlException)
        {
            studentResponse.isException=true;
            studentResponse.success=false;
            studentResponse.exception="not able to insert data in the database";
            return studentResponse;
        }

        studentResponse.success=true;
        studentResponse.hasResult=true;
        studentResponse.result=student;

        return studentResponse;
    }
    public StudentResponse update(Student student)
    {        
        StudentResponse studentResponse=new StudentResponse();
    
        try(PreparedStatement preparedStatement=this.connection.prepareStatement("UPDATE public.student SET name=?, address=? WHERE student.roll_number=?"))
        {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getAddress());
            preparedStatement.setInt(3,student.getRollNumber());
            preparedStatement.executeUpdate();

        }catch(SQLException sqlException)
        {
            studentResponse.isException=true;
            studentResponse.success=false;
            studentResponse.exception="not able to insert data in the database";
            return studentResponse;
        }

        studentResponse.success=true;
        studentResponse.hasResult=true;
        studentResponse.result=student;

        return studentResponse;
   
    }

    public StudentResponse delete(Integer rollNumber)
    {
        StudentResponse studentResponse=new StudentResponse();
    
        try(PreparedStatement preparedStatement=this.connection.prepareStatement("DELETE FROM public.student WHERE student.roll_number=?"))
        {
            preparedStatement.setInt(1,rollNumber);
            preparedStatement.executeUpdate();

        }catch(SQLException sqlException)
        {
            studentResponse.isException=true;
            studentResponse.success=false;
            studentResponse.exception="not able to insert data in the database";
            return studentResponse;
        }

        studentResponse.success=true;
        studentResponse.hasResult=true;

        return studentResponse;
   
    }




    
}
