package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.MenuMapper;
import com.gfxy.master.service.MenuService;
import com.gfxy.master.vo.ChildMenu;
import com.gfxy.master.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<String> selectPermsByUserId(Long userid) {
        return menuMapper.selectPermsByUserId(userid);
    }

    @Override
    public List<Menu> getMenu(List<String> perms) {
        List<Menu> menus = null;
        if (perms.size() == 1) {
            menus = menuMapper.selectPrentMenu(perms.get(0));
            List<ChildMenu> childMenus = menuMapper.selectChildMenu(perms.get(0));
            for (ChildMenu childMenu : childMenus) {
                for (Menu menu : menus) {
                    if (childMenu.getParentId() == menu.getId()) {
                        List<ChildMenu> list = new ArrayList<>();
                        list.add(childMenu);
                        menu.setChildMenus(list);
                    }
                }
            }
        } else {
            menus = menuMapper.selectPrentMenu(perms.get(1));
            for (Menu menu : menus) {
                menu.setChildMenus(menuMapper.selectMenuChildById(menu.getId()));
            }
        }
        return menus;
    }
}
