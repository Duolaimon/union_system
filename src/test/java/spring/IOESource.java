package spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author Duolaimon
 * 17-10-15 下午8:08
 */
public class IOESource {

    @Test
    public void getBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring-dao.xml");
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) applicationContext.getBean("dataSource");
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.getBean("");
    }

    @Test
    public void base64Test() {
        byte[] result = org.apache.shiro.codec.Base64.decode("4AvVhmFLUs0KTA3Kprsdag==");
        System.out.println(Arrays.toString(result));
        byte[] bytes = {-100,102,10,5,-90,-109,45,27,-122,75,52};
        System.out.println(org.apache.shiro.codec.Base64.encodeToString(bytes));
    }
}
