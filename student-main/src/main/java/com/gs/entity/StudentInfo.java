package com.gs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gs.annotation.ExcelAnnotation;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("xj_st_student")
@ExcelAnnotation(title = "学生信息", sheetName = "学生信息", mkdir = "student")
public class StudentInfo {
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    @ExcelAnnotation(column = "学生姓名")
    @TableField("studentName")
    private String studentName;
    @ExcelAnnotation(column = "年龄")
    @TableField("age")
    private Integer age;
    @ExcelAnnotation(column = "家庭住址")
    @TableField("address")
    private String address;
    @ExcelAnnotation(column = "照片路径")
    @TableField("img")
    private String img;
    @TableField("isDel")
    private Integer isDel;
    @ExcelAnnotation(column = "生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("birthday")
    private Date birthday;
    @TableField("ip")
    private String ip;
}
