package com.gfxy.master.mapper;

import com.gfxy.master.vo.Courses;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoursesMapper {

    /**
     * 查询所有课程信息
     *
     * @return
     */
    List<Courses> selectAllCourses();

    /**
     * 查询学生选的课程的数量
     *
     * @return
     */
    List<Courses> selectStudentCoursesNameCountByCourseName();

    /**
     * 根据 CoursesId 查询
     *
     * @param CoursesId
     * @return
     */
    Courses selectCoursesByCoursesId(int CoursesId);

    /**
     * 根据 id 查询
     *
     * @param id
     * @return
     */
    Courses selectCoursesById(int id);

    /**
     * 模糊查询所有字段
     *
     * @param coursesId
     * @return
     */
    List<Courses> searchByCoursesId(int coursesId);

    /**
     * @param id
     * @return
     */
    int deleteCoursesById(int id);

    /**
     * 增加
     *
     * @param courses
     * @return
     */
    int insertCourses(Courses courses);

    /**
     * 修改
     *
     * @param courses
     * @return
     */
    int updateCourses(Courses courses);


}
