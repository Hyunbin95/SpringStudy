package kr.co.pk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pk.dao.ItemDAO;
import kr.co.pk.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	
	
	@Override
	public List<Item> allItem() {
		return itemDAO.allItem();
	}



	@Override
	public Item getItem(int itemId) {
		return itemDAO.getItem(itemId);
	}
	
	

}
