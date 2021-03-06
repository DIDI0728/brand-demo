package Service;

import Mapper.BrandMapper;
import Pojo.Brand;
import Utils.sqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    SqlSessionFactory factory = sqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();


        sqlSession.close();

        return brands;


    }


    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }


    public Brand selectById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;

    }
    public void updata(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.updata(brand);

        sqlSession.commit();
        sqlSession.close();
    }
}