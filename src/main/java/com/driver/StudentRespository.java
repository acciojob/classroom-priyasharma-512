package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository

public class StudentRespository {

    private HashMap<String, Student> studentHashMap = new HashMap<String, Student>();;
    private HashMap<String, Teacher> teacherHashMap = new HashMap<String, Teacher>();;
    private HashMap<String, List<String>> pairHashMap = new HashMap<String, List<String>>();;


    public void addStudentRepo(Student student)
    {
        studentHashMap.put(student.getName(),student);
    }

    public void addTeacherRepo(Teacher teacher)
    {
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPairRepo(String student,String teacher)
    {
        if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher))
        {
            List<String> existingpair = new ArrayList<String>();
            if(pairHashMap.containsKey(teacher))
                existingpair = pairHashMap.get(teacher);
            existingpair.add(student);
            pairHashMap.put(teacher,existingpair);
        }
    }

    public Student getStudentByNameRepo(String student)
    {
        return studentHashMap.get(student);
    }

    public Teacher getTeacherByNameRepo(String teacher)
    {
        return teacherHashMap.get(teacher);
    }

    public List<String> getStudentsByTeacherNameRepo(String teacher)
    {
        List<String> studentsList = new ArrayList<String>();
        if(teacherHashMap.containsKey(teacher))
            studentsList = pairHashMap.get(teacher);
        return studentsList;
    }

    public List<String> getAllStudentsRepo()
    {
        return new ArrayList<>(studentHashMap.keySet());
    }

    public void deleteTeacherByNameRepo(String teacher)
    {
        List<String> std = new ArrayList<String>();
        if(pairHashMap.containsKey(teacher))
        {
            std = pairHashMap.get(teacher);
            for(String student : std)
            {
                if(studentHashMap.containsKey(student))
                    studentHashMap.remove(student);
            }
            pairHashMap.remove(teacher);
        }
        if(teacherHashMap.containsKey(teacher))
            teacherHashMap.remove(teacher);
    }

    public void deleteAllTeachersRepo()
    {
        HashSet<String> set = new HashSet<String>();
        for(String teacher: pairHashMap.keySet())
        {
            for(String student: pairHashMap.get(teacher))
            {
                set.add(student);
            }
        }
        for(String student: set)
        {
            if(studentHashMap.containsKey(student))
                studentHashMap.remove(student);
        }
    }

}
