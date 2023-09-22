package com.gfxy.master.controller;

import com.gfxy.master.service.HomeService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {


    @Autowired
    private HomeService homeService;

    @PostMapping("/admin/selectCourseChooseNumber")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectCourseChooseNumber() {

//        echarts 图 的格式 最终需要 courseName = ["水浒","红楼梦","西游记"]

        List<StudentCourse> lists = homeService.selectCourseChooseNumber();

        Map<String, Integer> data = new HashMap<>();

        for (int i = 0; i < lists.size(); i++) {
            // 获取每个对象的 CourseName 与 Number
            // 将其 写入 map 对象中
            data.put(lists.get(i).getCourseName(), lists.get(i).getNumber());
        }
        
//        System.out.println(data);   // {水浒=2, 红楼梦=2, 西游记=1, 三国志=1}
//        System.out.println(data.keySet());  // [水浒, 红楼梦, 西游记, 三国志]
//        System.out.println(data.values());  // [2, 2, 1, 1]

        List<String> courseName = new ArrayList<>(data.keySet());
        List<Integer> Number = new ArrayList<>(data.values());
        Map<String, Object> result = new HashMap<>();
        result.put("courseName", courseName);
        result.put("Number", Number);
//        System.out.println(result); // {courseName=[水浒, 红楼梦, 西游记, 三国志], Number=[2, 2, 1, 1]}

        return new ResponseResult(200, "查询成功", result);

    }
}
