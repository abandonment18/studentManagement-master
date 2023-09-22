package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.UnitsMapper;
import com.gfxy.master.service.UnitsService;
import com.gfxy.master.vo.Units;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitsServiceImpl implements UnitsService {

    @Autowired
    private UnitsMapper unitsMapper;

    @Override
    public List<Units> selectAllUnits() {
        return unitsMapper.selectAllUnits();
    }

    @Override
    public Units selectUnitsByTeacherId(int TeacherId) {
        return unitsMapper.selectUnitsByTeacherId(TeacherId);
    }

    @Override
    public List<Units> searchUnitsByTeachersId(int teacherId) {
        return unitsMapper.searchUnitsByTeachersId(teacherId);
    }

    @Override
    public List<Units> searchUnitsByName(String name) {
        return unitsMapper.searchUnitsByName(name);
    }

    @Override
    public int deleteUnitsById(int id) {
        return unitsMapper.deleteUnitsById(id);
    }

    @Override
    public int insertUnits(Units units) {
        return unitsMapper.insertUnits(units);
    }

    @Override
    public int updateUnits(Units units) {
        return unitsMapper.updateUnits(units);
    }
}
