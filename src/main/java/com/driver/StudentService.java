package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRespository studentRespository;

    public void addStudentService(Student student)
    {
        studentRespository.addStudentRepo(student);
    }

    public void addTeacherService(Teacher teacher)
    {
        studentRespository.addTeacherRepo(teacher);
    }

    public void addStudentTeacherPairService(String student,String teacher)
    {
        studentRespository.addStudentTeacherPairServiceRepo(student,teacher);
    }

    public Student getStudentByNameService(String name)
    {
        return studentRespository.getStudentByNameRepo(name);
    }

    public Teacher getTeacherByNameService(String name)
    {
        return studentRespository.getTeacherByNameServiceRepo(name);
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
