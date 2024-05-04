package com.gfxy.master;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

//import com.gfxy.master.vo.Teachers;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestSpring {
    //
//
    @Autowired
    private PasswordEncoder passwordEncoder;

    ////
////
////    @Autowired
////    private CoursesService coursesService;
////
////
////    @Autowired
////    private TeachersMapper teachersMapper;
////
////
////    @Autowired
////    private TestMapper testMapper;
////
////
////    @Autowired
////    private HomeService homeService;
////
////    @Autowired
////    private PersonalInfoService personalInfoService;
////
////    @Autowired
////    private MenuService menuService;
////
////    @Autowired
////    private RegisterMapper registerMapper;
////    @Autowired
////    private MenuMapper menuMapper;
//
    @Test
    public void TestPasswordEncoder() {
        System.out.println(passwordEncoder.encode("test"));
        System.out.println(passwordEncoder.matches("test", passwordEncoder.encode("$2a$10$yZw0SafUm0xGqv.sYEE8ku/pEOW1TrfYJpU2/Pn.n/9G3dFf6qdha")));
    }
//
//    @Test
//    public void TestSelectAll() {
////        System.out.println(coursesService.selectAll());
////        System.out.println(coursesService.searchByCoursesId(1));
////        System.out.println(coursesService.searchByCoursesId(3));
////        System.out.println(teachersMapper.getValue("三"));
////        System.out.println(personalInfoService.selectTeachersById(3));
////        PersonalInfo personalInfo = new PersonalInfo();
////        personalInfo.setUserType("1");
////        personalInfo.setAge(18);
////        personalInfoService.updatePersonalInfo(personalInfo);
////        System.out.println(personalInfo.getUserType().equals("1") && personalInfo.getUserType() == "1");
//
////        Courses courses = new Courses();
////        courses.setId(11);
//
////        List<Teachers> list = teachersMapper.selectListTeachersByTeacherId(courses.getTeacherID());
////        System.out.println(list);
//
////        List<StudentCourse> lists = homeService.selectCourseChooseNumber();
////        System.out.println(lists);
////        Map<String, Integer> data = new HashMap<>();
////        for (int i = 0; i < lists.size(); i++) {
////            data.put(lists.get(i).getCourseName(), lists.get(i).getNumber());
////        }
////        System.out.println(data.keySet());
////        System.out.println(data.values());
////        List<String> courseName = new ArrayList<>(data.keySet());
////        List<Integer> Number = new ArrayList<>(data.values());
////        Map<String, Object> result = new HashMap<>();
////        result.put("courseName", courseName);
////        result.put("Number", Number);
////        System.out.println(result.get(courseName));
//
////        System.out.println(coursesService.selectCoursesById(11) == null);
//        String id = UUID.randomUUID().toString().replace("-", "");
//        System.out.println(id);
//    }
//
//    @Test
//    public void Test() {
//        Teachers teachers = new Teachers();
//        teachers.setId(7);
//        teachers.setTeacherID(74);
//        teachers.setName("漳卅");
//        teachers.setGender("男女");
//        teachers.setTitle("啦啦啦");
//        teachers.setDepartment("离谱");
////        testMapper.insertTeachers(teachers);
////        testMapper.updateTeachers(teachers);
//    }
//
////    @Test
////    public void Test2() {
////        List<String> a = new ArrayList<>();
////        a.add("system:student:list");
////        a.add("system:dept:list");
////        System.out.println(a);
////
////        Map<String, List<Menu>> menu1 = menuService.getMenu(a.get(0));
////        Map<String, List<Menu>> menu2 = menuService.getMenu(a.get(1));
////        System.out.println(menu1);
////        System.out.println(menu2);
////
////        menu1.forEach((s, menus) -> {
////            System.out.println(menus);
////        });
////
////        menu2.forEach((s, menus) -> {
////            System.out.println(menus);
////        });
////        System.out.println("-------------");
////        List<Menu> menus1 = menu1.get("menuChild");
////        menus1.addAll(menu2.get("menuChild"));
////        System.out.println(menu1);
////
////        System.out.println("-------");
////        Map<String, List<Menu>> map = new HashMap<>();
////        map.put("menuParent", menu1.get("menuParent"));
////        map.put("menuChild", menus1);
////        System.out.println(map);
////    }
//
//    @Test
//    public void Test3() {
//        List<String> a = new ArrayList<>();
//        a.add("a");
//        a.add("b");
//        a.add("c");
//        System.out.println(a);
//
//        for (int i = 0; i < a.size(); i++) {
//            if (a.get(i).equals("b")) {
//                a.set(i, a.get(0));
//                a.set(0, "b");
//            }
//        }
//        System.out.println(a);
//    }
//
}
