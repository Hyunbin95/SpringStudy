package daum.hyunbin7195.SpringMVC;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Controller(클라이언트의 요청을 처리하는 객체) 클래스로 만들고
//객체 생성을 자동으로 해주는 어노테이션
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// /요청이 GET 방식으로 왔을 때 처리하는 메소드
	//디렉토리 패턴을 사용할 때는 디렉토리 부분은 제외하고 value에 설정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	//get.do 요청이 GET 방식으로 오는 경우 처리하는 메소드
	@RequestMapping(value="get.do", method=RequestMethod.GET)
	public void get(
		//num 과 name 파라미터 값을 읽어서 콘솔에 출력
		
		
		//String num = request.getParameter("num");
		//String name = request.getParameter("name");
		
		//num 형 변환은 자동
		@RequestParam("num") int num,
		@RequestParam("name") String name){
		System.out.println(num + ":" + name);
		
	}
	
	//post.do 요청이 POST 방식으로 오는 경우 처리하는 메소드
	@RequestMapping(value="post.do", method=RequestMethod.POST)
	public void post(@RequestParam("name") String name,
			@RequestParam("hobby") ArrayList<String> hobbies) {
		//num 과 name 파라미터 값을 읽어서 콘솔에 출력
		
		//파라미터 인코딩 처리 - 여기서 처리하면 처리할 때 마다 아래 코드를 작성
		//필터를 이용해서 요청이 올 때마다 필터에서 인코딩 처리를 하도록 설정
		/*
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		String name = request.getParameter("name");
		//checkbox or select 는 배열로 받아서 저장
		String [] hobbies = request.getParameterValues("hobby");
		*/
		System.out.println("name:" + name);
		System.out.print("hobby: ");
		for(String hobby : hobbies) {
			System.out.print(hobby + "\t");
		}
		System.out.println();
	}
	
	@RequestMapping(value="ajax.do", method=RequestMethod.GET)
	public void ajax(Command command) {
		
		System.out.println(command);
				
	}
	
	@RequestMapping(value="forward.do", method=RequestMethod.GET)
	public String forward(Model model) {
		//결과 페이지로 전달할 데이터
		model.addAttribute("msg", "forwarding에 전달할 data");
		//결과 페이지 이름 설정 : 앞에 redirct: 가 없으므로 포워딩
		return "result";
	}
	
	@RequestMapping(value="redirect.do", method=RequestMethod.GET)
	//RedirectAttributes는 redirect 할 때 데이터를 전달하기 위한 클래스
	public String redirect(RedirectAttributes attr) {
		//결과 페이지로 전달할 데이터
		attr.addFlashAttribute("msg", "redirect에 전달할 data");
		//결과 페이지 이름 설정 : 앞에 redirect: 가 없으므로 포워딩
		return "redirect:display.do";
	}
	
	@RequestMapping(value="display.do", method=RequestMethod.GET)
	//RedirectAttributes는 redirect 할 때 데이터를 전달하기 위한 클래스
	public String display(RedirectAttributes attr) {
		//결과 페이지 이름 설정 : 앞에 redirect: 가 없으므로 포워딩
		return "display";
	}
	
	//json 출력
	@RequestMapping(value="json.do", method=RequestMethod.GET)
	public @ResponseBody Command json() {
		Command command = new Command();
		command.setNum(1);
		command.setName("리현빈");
		return command;
	}
	
}
