package mybatis.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionDAO {
	@Autowired
	private SimpleJdbcInsert template;
	
	@Transactional
	public void insert() {
		template.withTableName("goods");
		Map<String, Object> map =
				new HashMap<String, Object>();
		map.put("code", 5005);
		map.put("name", "해파리");
		map.put("manufacture", "바닷속");
		map.put("price", 5000);
		
		template.execute(map);
		template.execute(map);
		
	}
	
}
