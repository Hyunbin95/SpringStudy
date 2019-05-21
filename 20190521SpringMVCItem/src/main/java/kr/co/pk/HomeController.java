package kr.co.pk;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.pk.domain.Item;
import kr.co.pk.service.ItemService;


@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//서비스의 메소드를 호출해서 결과를 저장
		List<Item> list = itemService.allItem();
		//결과 페이지에서 출력할 수 있도록 저장
		model.addAttribute("list", list);
		
		return "home";
	}
	
	
	//요청 detail/${itemid} 를 받는 요청을 처리하는 메소드
	@RequestMapping(value ="detail/{itemid}", method = RequestMethod.GET)
	public String detailView(Model model, @PathVariable int itemid) {
		//서비스 메소드 호출
		Item item = itemService.getItem(itemid);
		model.addAttribute("item", item);
		
		
		return "detail";
	}
	
}
