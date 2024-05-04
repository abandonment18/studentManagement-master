package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.PersonalInfoMapper;
import com.gfxy.master.service.PersonalInfoService;
import com.gfxy.master.vo.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Autowired
    private PersonalInfoMapper personalInfoMapper;

    @Override
    public int selectPersonalInfoById(int id) {
        return personalInfoMapper.selectPersonalInfoById(id);
    }

    @Override
    public PersonalInfo selectTeachersById(int id) {
        return personalInfoMapper.selectTeachersById(id);
    }

    @Override
    public PersonalInfo selectStudentsById(int id) {
        return personalInfoMapper.selectStudentsById(id);
    }

    @Override
    public int updatePersonalInfo(PersonalInfo personalInfo) {
        // 判断是 教师（userType = “0”） 还是 学生（userType = “1”）
        // 然后选择 修改 学生表 还是 教师表
        if (personalInfo.getUserType().equals("0")) {

            if (personalInfoMapper.updateTeachers(personalInfo) == personalInfoMapper.updateUser(personalInfo)) {
                return 1;
            }

        } else if (personalInfo.getUserType().equals("1")) {

            if (personalInfoMapper.updateStudents(personalInfo) == personalInfoMapper.updateUser(personalInfo)) {
                return 1;
            }
        }
        return 0;
    }
}
