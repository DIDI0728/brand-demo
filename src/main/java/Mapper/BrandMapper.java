package Mapper;

import Pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {


    List<Brand> selectAll();

    Brand selectByBrandname(Brand brand);

    Brand selectById(int id);

    void add(Brand brand);

    void delete(int id);

    void updata(Brand brand);
}
