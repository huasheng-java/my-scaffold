#脚手架：MyScaffold 搭建

#### 搭建日志
1. 连接mysql数据库: 使用阿里的Druid及其中的数据源监控后台，详见DruidConfig配置
2. 使用代码生成工具：org.mybatis.generator
3. 使用swagger 标准接口生成文档
4. 配置WebMvcConfig：手动加载静态文件（swagger中所需的静态文件）
5. 接入下载的后台脚手架：需要其的后台管理页面，shiro权限管理
       注意：swagger相关页面要注意过滤，不需权限验证。swagger要生成文档的接口中的参数不得有继承关系，否则易出现栈溢出异常





















































