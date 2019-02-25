package com.my.scaffold.base;

import com.google.common.base.Objects;
import com.my.scaffold.realm.AuthRealm;

import java.io.Serializable;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :  自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/29 18:26
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;

    public Long id;
    public String loginName;
    public String nickName;
    public String icon;

    public ShiroUser(Long id, String loginName, String nickName,String icon) {
        this.id = id;
        this.loginName = loginName;
        this.nickName = nickName;
        this.icon=icon;
    }

    public String getloginName() {
        return loginName;
    }
    public String getNickName() {
        return nickName;
    }
    public String getIcon() {
        return icon;
    }
    public Long getId() {
        return id;
    }



    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return nickName;
    }

    /**
     * 重载hashCode,只计算loginName;
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(loginName);
    }

    /**
     * 重载equals,只计算loginName;
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ShiroUser other = (ShiroUser) obj;
        if (loginName == null) {
            return other.loginName == null;
        } else {
            return loginName.equals(other.loginName);
        }
    }
}
