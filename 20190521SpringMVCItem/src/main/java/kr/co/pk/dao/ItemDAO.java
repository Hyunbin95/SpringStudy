package kr.co.pk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.pk.domain.Item;

@Repository
public class ItemDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//Item 테이블의 모든 데이터를 가져오는 메소드
	public List<Item> allItem(){
		return sqlSession.selectList("itemMapper.allItem");
	}
	
	//itemid를 이용해서 item 테이블에서 데이터를 가져오는 메소드
	public Item getItem(int itemId){
		return sqlSession.selectOne("itemMapper.getItem", itemId);
	}
}
