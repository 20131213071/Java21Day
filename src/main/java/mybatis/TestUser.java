package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by smx on 2017/8/31.
 * Param
 */
public class TestUser {
    public static void main(String[] args) throws IOException{
        //mybatis配置文件
        String resource = "conf.xml";

        //1、使用类加载器加载mybatis的配置文件
        InputStream inputStream = TestUser.class.getClassLoader().getResourceAsStream(resource);
        //2、使用mybatis提供的Resources类加载mybatis的配置文件
        Reader reader = Resources.getResourceAsReader(resource);

        //1、构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2、构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String  string = "me.gacl.mapping.userMapper";
        User user = sqlSession.selectOne(string,1);
        System.out.println(user);


    }
}
