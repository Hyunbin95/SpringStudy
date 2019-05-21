package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import ioc.Player;
import ioc.PlayerDAO;

public class Main {
	//일반 디바이스 용 애플리케이션의 entry point(시작점)
	public static void main(String[] args) {
		//try ~ resources 구문 : 1.7 버전 이상부터 사용이 가능
		//()안에서 AutoClosable 인터페이스가 구현된 클래스의 인터페이스를 만들면
		//try ~ catch 구문이 종료되면 자동으 close를 호출
		try(
				
				/*
		//Annotation으로 설정 BeanFactory 클래스 가져오기
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DAOFactory.class)
				*/
				
			//XML 파일을 이용 ApplicationContext 생성
			GenericXmlApplicationContext context =
			new GenericXmlApplicationContext(
					"classpath:applicationContext.xml");
				){
			System.err.println(context);
			//Bean 생성 - playerDAO 라 id를 가진 bean 태그를 이용해서
			//Player DAO 클래스 타입의 객체를 생성해서 리턴
			PlayerDAO dao =
					context.getBean("playerDAO", PlayerDAO.class);
			
			/*
			PlayerDAO dao =
					context.getBean("create", PlayerDAO.class);
			PlayerDAO dao1 =
					context.getBean("create", PlayerDAO.class);
		*/
			
			System.err.println(dao);
			//System.err.println(dao1);
			
			Player player = dao.getPlayer();
			System.err.println(player);
		
			
		}catch(Exception e) {
			System.out.println("Spring IoC Exception:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
