package com.gs.controller;

import com.gs.entity.StudentInfo;
import com.gs.service.StudentService;
import com.gs.util.ExportExcel;
import com.gs.util.FileCopy;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("pagingQueryStudent")
    public PageBean<StudentInfo> pagingQueryStudent(PageBean<StudentInfo> pageBean){
        studentService.pagingQueryStudent(pageBean);
        return pageBean;
    }

    @RequestMapping("uploadFile")
    public Map<String, Object> uploadFile(@RequestParam(value = "photo") MultipartFile photo) throws FileNotFoundException {
        Map<String, Object> map = new HashMap<String, Object>();
        String url = FileCopy.copyFile(photo, "/static/upload");
        map.put("url", url);
        return map;
    }

    @RequestMapping("saveStudent")
    public String saveStudent(StudentInfo studentInfo){
        studentService.saveStudent(studentInfo);
        return "200";
    }

    @RequestMapping("deleteStudent")
    public String deleteStudent(String id){
        studentService.deleteStudent(id);
        return "200";
    }

    @RequestMapping("queryStudentById")
    public StudentInfo queryStudentById(String id){
        StudentInfo studentInfo = studentService.queryStudentById(id);
        return studentInfo;
    }

    @RequestMapping("updateStudent")
    public String updateStudent(StudentInfo studentInfo){
        studentService.updateStudent(studentInfo);
        return "200";
    }

    @RequestMapping("importExcel")
    public String importExcel() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, FileNotFoundException {
        List<StudentInfo> studentList = studentService.queryStudentList();
        if (studentList.size() == 0){
            return "500";
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIsDel() == 0){
                return "400";
            }
        }
        ExportExcel.exportExcel(studentList, StudentInfo.class);
        return "200";
    }
}
