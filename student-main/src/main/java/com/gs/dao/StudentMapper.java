package com.gs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gs.entity.StudentInfo;
import com.gs.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper extends BaseMapper<StudentInfo> {
    Long totalNumber();

    List<StudentInfo> pagingQueryStudent(PageBean<StudentInfo> pageBean);

    void deleteStudent(String id);

    StudentInfo queryStudentById(String id);
}
