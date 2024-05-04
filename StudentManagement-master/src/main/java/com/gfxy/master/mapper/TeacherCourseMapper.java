package com.gfxy.master.mapper;

import com.gfxy.master.vo.Courses;
import com.gfxy.master.vo.TeacherCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherCourseMapper {

    /**
     * 查询所有教师选课信息
     *
     * @return
     */
    List<TeacherCourse> selectAllTeacherCourse();

    /**
     * 根据 TeacherId，CourseId 查询教教师选课信息
     *
     * @param courses
     * @return
     */
    TeacherCourse selectTeacherCourseByTeacherIdAndCourseId(Courses courses);

    /**
     * 根据 TeacherId 查询
     *
     * @param TeacherId
     * @return
     */
    TeacherCourse selectTeacherCourseByTeacherId(int TeacherId);

    /**
     * 根据教师编号模糊查询所有字段
     *
     * @return
     */
    List<TeacherCourse> searchTeacherCourseByTeachersId(int teacherId);

    /**
     * 根据教师名称模糊查询所有字段
     *
     * @return
     */
    List<TeacherCourse> searchTeacherCourseByTeacherName(String name);

    /**
     * 根据课程名称模糊查询所有字段
     *
     * @return
     */
    List<TeacherCourse> searchTeacherCourseByCourseName(String name);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteTeacherCourseById(int id);


    /**
     * 增加
     *
     * @param teacherCourse
     * @return
     */
    int insertTeacherCourse(TeacherCourse teacherCourse);

    /**
     * 修改
     *
     * @param teacherCourse
     * @return
     */
    int updateTeacherCourse(TeacherCourse teacherCourse);
}
