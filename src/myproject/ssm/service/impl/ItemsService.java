package myproject.ssm.service.impl;

import java.util.List;

import myproject.ssm.po.ItemsCustom;
import myproject.ssm.po.ItemsQueryVo;

public interface ItemsService {
	//��Ʒ��ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	//����id��ѯ��Ʒ��Ϣ
	public ItemsCustom findItemsById(Integer id)throws Exception;
	//�޸���Ʒ��Ϣ
	public void updateItems(Integer id,ItemsQueryVo itemsQueryVo)throws Exception;
}
