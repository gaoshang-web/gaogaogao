package com.gs.service;

import com.gs.dao.StudentMapper;
import com.gs.entity.StudentInfo;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentDao;

    @Override
    public void pagingQueryStudent(PageBean<StudentInfo> pageBean) {
        Long totalCount = studentDao.totalNumber();
        pageBean.setRecordsTotal(totalCount);
        pageBean.setRecordsFiltered(totalCount);
        List<StudentInfo> studentList = studentDao.pagingQueryStudent(pageBean);
        pageBean.setData(studentList);
    }

    @Override
    public void saveStudent(StudentInfo studentInfo) {
        studentInfo.setIsDel(1);
        studentDao.insert(studentInfo);
    }

    @Override
    public void deleteStudent(String id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public StudentInfo queryStudentById(String id) {
        return studentDao.queryStudentById(id);
    }

    @Override
    public void updateStudent(StudentInfo studentInfo) {
        studentDao.updateById(studentInfo);
    }

    @Override
    public List<StudentInfo> queryStudentList() {
        return studentDao.selectList(null);
    }
}
