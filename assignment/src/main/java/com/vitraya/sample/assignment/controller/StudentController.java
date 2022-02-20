package com.vitraya.sample.assignment.controller;

import com.vitraya.sample.assignment.pojo.*;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vitraya.sample.assignment.dl.StudentService;
import com.vitraya.sample.assignment.exceptions.*;

@RestController
public class StudentController
{
    @Autowired
    private Map<Integer,Student> students;
    @Autowired
    private StudentService studentService;

    @PostMapping("/student/add")
    public StudentResponse add(@RequestBody Student student)throws StudentException
    {
        StudentResponse studentResponse=new StudentResponse();
        if(student.getRollNumber()!=null)
        {
            studentResponse.isError=true;
            studentResponse.success=false;
            studentResponse.error="Invalid student";
            return studentResponse;
        }

        if(student.isValid())
        {
            studentResponse.success=true;
            studentResponse.hasResult=true;
            studentResponse=this.studentService.add(student);
            if(studentResponse.success)
            {
                Student s=(Student)studentResponse.result;
                this.students.put(s.getRollNumber(),s);
            }
            return studentResponse;
        }
        else{
            studentResponse.isError=true;
            studentResponse.success=false;
            studentResponse.error="Invalid student";
            return studentResponse;
        }

   }


    @PostMapping("/student/update")
    public StudentResponse update(@RequestBody Student student)throws StudentException
    {
        StudentResponse studentResponse=new StudentResponse();
        if(!student.isValid())
        {
            studentResponse.isError=true;
            studentResponse.success=false;
            studentResponse.error="Invalid student";
            return studentResponse;
        }

        if(this.students.containsKey(student.getRollNumber()))
        {
            studentResponse.success=true;
            studentResponse=this.studentService.update(student);
            if(studentResponse.success)
            {
                this.students.remove(student.getRollNumber());
                this.students.put(student.getRollNumber(),(Student)studentResponse.result);
            }
            return studentResponse;
        }
        else
        {
            studentResponse.isError=true;
            studentResponse.success=false;
            studentResponse.error="Student not present";
            return studentResponse;
        }

    }

    @PostMapping("/student/delete")
    public StudentResponse delete(@RequestParam(name="rollNumber")  Integer rollNumber)throws StudentException
    {
        StudentResponse studentResponse;
        if(!this.students.containsKey(rollNumber))
        {
            studentResponse=new StudentResponse();
            studentResponse.isError=true;
            studentResponse.success=false;
            studentResponse.error="Invalid roll number.";
            return studentResponse;
        }
        
        studentResponse=this.studentService.delete(rollNumber);   
        this.students.remove(rollNumber);
        return studentResponse;
    }

    @PostMapping("/student/search")
    public StudentResponse search(@RequestParam(name="query") String query)throws StudentException
    {
        StudentResponse studentResponse=new StudentResponse();
        if(query.length()==0)
        {
            studentResponse.success=false;
            studentResponse.isError=true;
            studentResponse.error="Query can't be empty";
            return studentResponse;
        }
        String q=query.toLowerCase();
        List<Student> students=new LinkedList<>();

        this.students.forEach((k,v)->
        {
            Student s;
            s=(Student)v;
            if(s.getName().toLowerCase().contains(q)||s.getAddress().toLowerCase().contains(q))students.add(s);
        });
        studentResponse.success=true;
        studentResponse.hasResult=true;
        studentResponse.result=students;
        return studentResponse;
    }

    @PostMapping("/student/getAll")
    public StudentResponse  getAll()throws StudentException
    {
        List<Student> students=new LinkedList<>();
        
        this.students.forEach((k,v)->
        {
            Student s;
            s=(Student)v;
            students.add(s);
        });
        
        StudentResponse studentResponse=new StudentResponse();
        studentResponse.success=true;
        studentResponse.hasResult=true;
        studentResponse.result=students;
        return studentResponse;
    }

}