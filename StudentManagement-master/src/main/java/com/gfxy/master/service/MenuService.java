package com.gfxy.master.service;

import com.gfxy.master.vo.Menu;

import java.util.List;

public interface MenuService {

    List<String> selectPermsByUserId(Long userid);

    List<Menu> getMenu(List<String> perms);
}
