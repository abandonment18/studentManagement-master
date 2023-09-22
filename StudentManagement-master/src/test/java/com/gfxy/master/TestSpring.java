package com.gfxy.master;

import com.gfxy.master.mapper.TeachersMapper;
import com.gfxy.master.mapper.TestMapper;
import com.gfxy.master.service.CoursesService;
import com.gfxy.master.service.HomeService;
import com.gfxy.master.service.PersonalInfoService;
import com.gfxy.master.vo.Teachers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootTest
public class TestSpring {


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private CoursesService coursesService;


    @Autowired
    private TeachersMapper teachersMapper;


    @Autowired
    private TestMapper testMapper;


    @Autowired
    private HomeService homeService;

    @Autowired
    private PersonalInfoService personalInfoService;

    @Test
    public void TestPasswordEncoder() {
        System.out.println(passwordEncoder.encode("4"));
        System.out.println(passwordEncoder.matches("4", passwordEncoder.encode("4")));
    }

    @Test
    public void TestSelectAll() {
//        System.out.println(coursesService.selectAll());
//        System.out.println(coursesService.searchByCoursesId(1));
//        System.out.println(coursesService.searchByCoursesId(3));
//        System.out.println(teachersMapper.getValue("三"));
//        System.out.println(personalInfoService.selectTeachersById(3));
//        PersonalInfo personalInfo = new PersonalInfo();
//        personalInfo.setUserType("1");
//        personalInfo.setAge(18);
//        personalInfoService.updatePersonalInfo(personalInfo);
//        System.out.println(personalInfo.getUserType().equals("1") && personalInfo.getUserType() == "1");

//        Courses courses = new Courses();
//        courses.setId(11);

//        List<Teachers> list = teachersMapper.selectListTeachersByTeacherId(courses.getTeacherID());
//        System.out.println(list);

//        List<StudentCourse> lists = homeService.selectCourseChooseNumber();
//        System.out.println(lists);
//        Map<String, Integer> data = new HashMap<>();
//        for (int i = 0; i < lists.size(); i++) {
//            data.put(lists.get(i).getCourseName(), lists.get(i).getNumber());
//        }
//        System.out.println(data.keySet());
//        System.out.println(data.values());
//        List<String> courseName = new ArrayList<>(data.keySet());
//        List<Integer> Number = new ArrayList<>(data.values());
//        Map<String, Object> result = new HashMap<>();
//        result.put("courseName", courseName);
//        result.put("Number", Number);
//        System.out.println(result.get(courseName));

//        System.out.println(coursesService.selectCoursesById(11) == null);
        String id = UUID.randomUUID().toString().replace("-", "");
        System.out.println(id);
    }

    @Test
    public void Test() {
        Teachers teachers = new Teachers();
        teachers.setId(7);
        teachers.setTeacherID(74);
        teachers.setName("漳卅");
        teachers.setGender("男女");
        teachers.setTitle("啦啦啦");
        teachers.setDepartment("离谱");
        testMapper.insertTeachers(teachers);
//        testMapper.updateTeachers(teachers);
    }
}
