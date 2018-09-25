package linqh.test.demo1.test.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import linqh.test.demo1.test.model.AlarmInfoCfg;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AlarmInfoCfgMapper extends BaseMapper<AlarmInfoCfg> {

    @Select("SELECT *" +
            "  FROM alarm_info_cfg")
    List<AlarmInfoCfg> listByAnnotation();

    List<AlarmInfoCfg> listByXML();
}
