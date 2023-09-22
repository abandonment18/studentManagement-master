package com.gfxy.master.service.impl;

import com.gfxy.master.mapper.MenuMapper;
import com.gfxy.master.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<String> selectPermsByUserId(Long userid) {
        return menuMapper.selectPermsByUserId(userid);
    }
}
