package com.huxp.demo.controller.structure;

import java.util.List;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午2:27
 */
public class UserRole {
    private String userId;
    private List<String> roleIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
