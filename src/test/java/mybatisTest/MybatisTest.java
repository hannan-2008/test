package mybatisTest;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import lombok.extern.slf4j.Slf4j;
import mapper.UsermMapper;
import po.Userm;

@Slf4j
public class MybatisTest {
	@Test
	public void test4() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UsermMapper mapper = sqlSession.getMapper(UsermMapper.class);
		Userm userm = mapper.selectUserm(1);
		log.info("userm:{}", userm);

	}

}
