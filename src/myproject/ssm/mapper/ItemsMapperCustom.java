package myproject.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import myproject.ssm.po.Items;
import myproject.ssm.po.ItemsCustom;
import myproject.ssm.po.ItemsExample;
import myproject.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}