package com.my.scaffold.service;


import com.baomidou.mybatisplus.service.IService;
import com.my.scaffold.dal.entity.UploadInfo;

/**
 * <p>
 * 文件上传配置 服务类
 * </p>
 *
 * @author wangl
 * @since 2018-07-06
 */
public interface UploadInfoService extends IService<UploadInfo> {

    public UploadInfo getOneInfo();

    public void updateInfo(UploadInfo uploadInfo);

}
