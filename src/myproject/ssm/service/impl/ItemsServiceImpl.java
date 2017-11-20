package myproject.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import myproject.ssm.mapper.ItemsMapper;
import myproject.ssm.mapper.ItemsMapperCustom;
import myproject.ssm.po.Items;
import myproject.ssm.po.ItemsCustom;
import myproject.ssm.po.ItemsQueryVo;

public class ItemsServiceImpl implements ItemsService{
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		ItemsCustom itemsCustom=null;
		Items items=itemsMapper.selectByPrimaryKey(id);
		if(items!=null) {
			itemsCustom=new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		return itemsCustom;
	}
	@Override
	public void updateItems(Integer id, ItemsQueryVo itemsQueryVo) throws Exception {
		//必须有id才能更新，所以防止万一
		itemsQueryVo.getItemsCustom().setId(id);
		//更新商品信息，根据主键更新items表中的所有字段，包括大文本信息
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsQueryVo.getItemsCustom());
	}
}
