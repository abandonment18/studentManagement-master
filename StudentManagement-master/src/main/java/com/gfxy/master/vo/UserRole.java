package com.gfxy.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色 与 用户 关联表的字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    /**
     * 用户 id
     */
    private Long UserId;

    /**
     * 角色 id
     */
    private int RoleId;
}
