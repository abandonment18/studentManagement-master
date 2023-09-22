package com.gfxy.master.controller;

import com.gfxy.master.service.TeachersService;
import com.gfxy.master.service.UnitsService;
import com.gfxy.master.vo.ResponseResult;
import com.gfxy.master.vo.Teachers;
import com.gfxy.master.vo.Units;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnitsController {

    @Autowired
    private UnitsService unitsService;

    @Autowired
    private TeachersService teachersService;


    /**
     * 分页请求接口
     *
     * @param pageNum:要显示第几页,默认为     1
     * @param pageSize:每页要显示几条数据,默认为 5
     * @return
     */
    @GetMapping("/admin/units")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

//        System.out.println(pageNum);
//        System.out.println(pageSize);
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 说明:
        // 1. 调用 findAll 是完成查询,底层会进行物理分页,而不是逻辑分页
        // 2. 会根据分页参数来计算 limit ?,?,在发出 sql 语句时,会带 limit
        List<Units> list = unitsService.selectAllUnits();

        // 将分页查询的结果,封装到 PageInfo
        // PageInfo 对象包含了分页的各个信息,比如当前页 pageNum,共有多少记录
        PageInfo<Units> pageInfo = new PageInfo<>(list, pageSize);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 根据 TeachersId 进行搜索匹配
     *
     * @param teacherId
     * @return
     */
    @PostMapping("/admin/searchUnitsByTeacherId")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchUnitsByTeacherId(@RequestParam("teachersId") int teacherId) {

        return new ResponseResult(200, "查询成功", unitsService.searchUnitsByTeachersId(teacherId));
    }

    /**
     * 根据 name 进行模糊搜索
     *
     * @param name
     * @return
     */
    @PostMapping("/admin/searchUnitsByName")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult searchUnitsByName(@RequestParam("name") String name) {

        return new ResponseResult(200, "查询成功", unitsService.searchUnitsByName(name));
    }

    /**
     * 根据 id 删除
     *
     * @param id
     * @return
     */
    @PostMapping("/admin/deleteUnitsById")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult deleteUnitsById(@RequestParam("id") int id) {

        return new ResponseResult(200, "删除成功", unitsService.deleteUnitsById(id));
    }

    /**
     * 新增教师单位
     *
     * @param units
     * @return
     */
    @PostMapping("/admin/insertUnits")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult insertUnits(@RequestBody Units units) {

        Teachers teachers = teachersService.selectTeachersByTeacherId(units.getTeacherID());
        if (teachers == null) {
            return new ResponseResult(300, "增加失败，没有该教师！");
        } else if (teachers.getTeacherID() != units.getTeacherID()) {
            return new ResponseResult(300, "增加失败，教师编号错误！");
        } else if (!teachers.getName().equals(units.getTeacherName())) {
            return new ResponseResult(300, "增加失败，教师名称错误！");
        } else if (!teachers.getDepartment().equals(units.getUnitName())) {
            return new ResponseResult(300, "增加失败，学院名称错误！");
        } else if (unitsService.selectUnitsByTeacherId(units.getTeacherID()) != null) {
            return new ResponseResult(300, "增加失败，该教师编号已有，请重新输入！");
        }
        return new ResponseResult(200, "增加成功", unitsService.insertUnits(units));
    }


    /**
     * 修改教师单位
     *
     * @param units
     * @return
     */
    @PostMapping("/admin/updateUnits")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public ResponseResult updateUnits(@RequestBody Units units) {
        Teachers teachers = teachersService.selectTeachersByTeacherId(units.getTeacherID());
        if (teachers == null) {
            return new ResponseResult(300, "修改失败，没有该教师！");
        } else if (teachers.getTeacherID() != units.getTeacherID()) {
            return new ResponseResult(300, "修改失败，教师编号错误！");
        } else if (!teachers.getName().equals(units.getTeacherName())) {
            return new ResponseResult(300, "修改失败，教师名称错误！");
        } else if (!teachers.getDepartment().equals(units.getUnitName())) {
            return new ResponseResult(300, "修改失败，学院名称错误！");
        }
        return new ResponseResult(200, "修改成功", unitsService.updateUnits(units));
    }
}
