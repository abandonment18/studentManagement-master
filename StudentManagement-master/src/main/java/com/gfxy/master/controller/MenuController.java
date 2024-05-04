package com.gfxy.master.controller;

import com.gfxy.master.service.MenuService;
import com.gfxy.master.utils.JwtUtil;
import com.gfxy.master.vo.Menu;
import com.gfxy.master.vo.ResponseResult;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * 有问题
 */
@Tag(name = "MenuController", description = "菜单管理")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Operation(summary = "查询菜单", description = "查询菜单")
    @PostMapping("/admin/selectMenu")
    @PreAuthorize("hasAnyAuthority('system:dept:list','system:student:list')")
    public ResponseResult selectMenu(@RequestBody Menu menu) {

        try {
            Claims claims = JwtUtil.parseJWT(menu.getToken());
            String userId = claims.getSubject();
            List<Menu> menuList = menuService.getMenu(menuService.selectPermsByUserId(Long.valueOf(userId)));
            for (int i = 0; i < menuList.size(); i++) {
                // 将首页放在第一位
                if (menuList.get(i).getMenuName().equals("首页")) {
                    /**
                     * List集合中任意两个位置的数据互相调换（swap）
                     * 源码 public static void swap(List<?> list, int i, int j) {
                     *         final List l = list;
                     *         l.set(i, l.set(j, l.get(i)));
                     *     }
                     */
                    Collections.swap(menuList, i, 0);
                }
                if (menuList.get(i).getMenuName().equals("课程信息")) {
                    Collections.swap(menuList, i, 1);
                }
                // 将设置放在最后一位
                if (menuList.get(i).getMenuName().equals("设置")) {
                    Collections.swap(menuList, i, menuList.size() - 1);
                }
            }
            return new ResponseResult(200, menuList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
