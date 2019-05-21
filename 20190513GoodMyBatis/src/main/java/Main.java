import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import good.service.GoodService;

public class Main {
	public static void main(String[] args) {
		//입력을 받기 위한 인스턴스를 생성
		Scanner sc = new Scanner(System.in);
		
		//service 인스턴스 가져오기
		//스프링 설정 파일 실행
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");
			
		
		GoodService service = context.getBean(
				"goodService", GoodService.class);
		
		
		
		
		
		//레이블을 붙인 반복문 - break 나 continue 뒤에 레이블을 붙이면
		//레이블이 붙은 반복문을 종료
		logic: while(true) {
			System.out.println("============================");
			System.out.println(
					"1.전체보기\n2.코드검색\n3.데이터삽입\n4.데이터 수정\n5.데이터 삭제\n0.종료");
			System.out.print("메뉴 입력:");
			String input = sc.nextLine();
			System.out.println();
			
			int menu = -1;
			try {
				//입력받은 내용을 정수로 변환
				menu = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println("메뉴는 정수로 입력하세요");
				continue;
			}
			//메뉴 범위를 넘어서면 다시 처음으로
			if(menu < 0 || 6 < menu) {
				System.out.println("메뉴는 1~6 사이의 숫자만 입력하세요");
				continue;
			}
			
			switch(menu) {
				case 1:
					System.out.println("전체보기");
					service.allGood();
					break;
				case 2:
					System.out.println("코드검색");
					break;
				case 3:
					System.out.println("데이터삽입");
					break;
				case 4:
					System.out.println("데이터 수정");
					break;
				case 5:
					System.out.println("데이터 삭제");
					break;
				case 0:
					System.out.println("종료");
					//logic 이라는 레이블을 가진 반복문을 종료
					break logic;
			}
			
		}
		
		
			
		
		sc.close();
		context.close();
		//프로그램 정상 종료
		System.exit(0);
	}
}
