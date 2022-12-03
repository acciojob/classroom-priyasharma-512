package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRespository studentRespository;

    public void addStudent(Student student)
    {
        studentRespository.addStudentRepo(student);
    }

    public void addTeacher(Teacher teacher)
    {
        studentRespository.addTeacherRepo(teacher);
    }

    public void addStudentTeacherPairService(String student,String teacher)
    {
        studentRespository.addStudentTeacherPairRepo(student,teacher);
    }

    public Student getStudentByNameService(String stdname)
    {
        return studentRespository.getStudentByNameRepo(stdname);
    }

    public Teacher getTeacherByNameService(String tname)
    {
        return studentRespository.getTeacherByNameRepo(tname);
    }

    public List<String> getStudentsByTeacherNameService(String teacher)
    {
        return studentRespository.getStudentsByTeacherNameRepo(teacher);
    }

    public List<String> getAllStudentsService()
    {
        return studentRespository.getAllStudentsRepo();
    }

    public void deleteTeacherByNameService(String teacher)
    {
        studentRespository.deleteTeacherByNameRepo(teacher);
    }

    public void deleteAllTeachersService()
    {
        studentRespository.deleteAllTeachersRepo();
    }

}
