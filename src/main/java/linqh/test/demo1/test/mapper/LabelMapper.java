package linqh.test.demo1.test.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import linqh.test.demo1.test.model.Label;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LabelMapper extends BaseMapper<Label> {

    @Select("SELECT *" +
            "  FROM label")
    List<Label> all();
}
