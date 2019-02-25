package com.my.scaffold.service;

import com.baomidou.mybatisplus.service.IService;
import com.my.scaffold.dal.entity.Rescource;
/**
 * <p>
 * 系统资源 服务类
 * </p>
 *
 * @author wangl
 * @since 2018-01-14
 */
public interface RescourceService extends IService<Rescource> {

    int getCountByHash(String hash);

    Rescource getRescourceByHash(String hash);

}
