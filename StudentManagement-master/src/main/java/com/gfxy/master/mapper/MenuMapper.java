package com.gfxy.master.mapper;

import com.gfxy.master.vo.ChildMenu;
import com.gfxy.master.vo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<String> selectPermsByUserId(Long userid);

    List<Menu> selectPrentMenu(String perms);

    List<ChildMenu> selectChildMenu(String perms);

    List<ChildMenu> selectMenuChildById(Long id);
}
