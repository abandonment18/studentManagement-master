package com.gfxy.master.service;

import com.gfxy.master.vo.Units;

import java.util.List;

public interface UnitsService {
    /**
     * 查询所有教师单位信息
     *
     * @return
     */
    List<Units> selectAllUnits();

    /**
     * 根据 TeacherId 查询
     *
     * @param TeacherId
     * @return
     */
    Units selectUnitsByTeacherId(int TeacherId);

    /**
     * 根据教师编号模糊查询所有字段
     *
     * @return
     */
    List<Units> searchUnitsByTeachersId(int teacherId);

    /**
     * 根据名称模糊查询所有字段
     *
     * @return
     */
    List<Units> searchUnitsByName(String name);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteUnitsById(int id);


    /**
     * 增加
     *
     * @param units
     * @return
     */
    int insertUnits(Units units);

    /**
     * 修改
     *
     * @param units
     * @return
     */
    int updateUnits(Units units);

}
