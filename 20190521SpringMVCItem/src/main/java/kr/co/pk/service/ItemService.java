package kr.co.pk.service;

import java.util.List;

import kr.co.pk.domain.Item;

public interface ItemService {
	//테이블의 전체 데이터를 가져오는 메소드
	public List<Item> allItem();
	
	//테이블의 데이터를 itemid로 가져오는 메소드
	public Item getItem(int itemId);
}
