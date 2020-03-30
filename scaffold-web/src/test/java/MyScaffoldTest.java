import com.my.scaffold.MyScaffoldApplication;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/7/16 9:36
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyScaffoldApplication.class)
@WebAppConfiguration
public class MyScaffoldTest {

    @Autowired
    private SecurityManager securityManager;
    @Test
    public void test(){
        UsernamePasswordToken token = new UsernamePasswordToken("test","1",false);
        try {
            SecurityUtils.setSecurityManager(securityManager);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            if (subject.isAuthenticated()) {
                System.out.println("认证通过");
            }

            subject.logout();
            System.out.println("退出登录");
        }catch (IncorrectCredentialsException e) {
            System.out.println("登录密码错误.");
        } catch (ExcessiveAttemptsException e) {
            System.out.println("登录失败次数过多");
        } catch (LockedAccountException e) {
            System.out.println("帐号已被锁定.");
        } catch (DisabledAccountException e) {
            System.out.println("帐号已被禁用.");
        } catch (ExpiredCredentialsException e) {
            System.out.println("帐号已过期.");
        } catch (UnknownAccountException e) {
            System.out.println("帐号不存在");
        } catch (UnauthorizedException e) {
            System.out.println("您没有得到相应的授权！");
        }

    }


}
