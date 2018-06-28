package xin.qiliuhai.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.qiliuhai.mapper.UserInfoDao;
import xin.qiliuhai.po.UserInfo;

import javax.annotation.Resource;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserInfoTest {
    @Resource(name="userInfoDao")
    private UserInfoDao userInfoDao;

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
    @Test
    public void testFindAll(){
        List<UserInfo> list=userInfoDao.findAll();
        System.out.println(list);
    }
}
