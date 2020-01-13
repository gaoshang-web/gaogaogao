package com.gs.service;

import com.gs.entity.StudentInfo;
import com.gs.util.PageBean;

import java.util.List;

public interface StudentService {
    void pagingQueryStudent(PageBean<StudentInfo> pageBean);

    void saveStudent(StudentInfo studentInfo);

    void deleteStudent(String id);

    StudentInfo queryStudentById(String id);

    void updateStudent(StudentInfo studentInfo);

    List<StudentInfo> queryStudentList();
}
