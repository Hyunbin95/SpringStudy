package db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodService {
	
	@Autowired
	private GoodDAO goodDAO;
	
	public Good get() {
		return goodDAO.get();
	}
}
