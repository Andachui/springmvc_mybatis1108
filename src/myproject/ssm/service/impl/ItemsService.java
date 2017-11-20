package myproject.ssm.service.impl;

import java.util.List;

import myproject.ssm.po.ItemsCustom;
import myproject.ssm.po.ItemsQueryVo;

public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	//根据id查询商品信息
	public ItemsCustom findItemsById(Integer id)throws Exception;
	//修改商品信息
	public void updateItems(Integer id,ItemsQueryVo itemsQueryVo)throws Exception;
}
