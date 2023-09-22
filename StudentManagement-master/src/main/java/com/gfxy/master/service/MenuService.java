package com.gfxy.master.service;

import java.util.List;

public interface MenuService {

    List<String> selectPermsByUserId(Long userid);
}
