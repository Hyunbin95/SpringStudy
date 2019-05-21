package good.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import good.dao.GoodMapper;
import good.domain.Good;

//Service 클래스의 인스턴스를 자동으로 생성해주는 어노테이션
@Service
public class GoodService { 
	@Autowired
	private GoodMapper goodDAO;
	
	//전체보기를 수행할 메소드
	public void allGood() {
		List<Good> list = goodDAO.allGood();
		
		//데이터 출력
		for(Good good : list) {
			System.out.println(good);
		}
	}
	
	//코드를 입력받아서 데이터를 조회한 후 출력해주는 메소드
	public void codeSearch(Scanner sc) {
		while(true) {
			System.out.print("Enter Code Number : ");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println("Plz Enter Only Number");
				continue;
			}
			//DAO의 메소드 호출
			Good good = goodDAO.codeSearch(code);
			//데이터가 없는 경우
			if(good == null) {
				System.out.println("404 Data Not Found");
			}
			//데이터가 있는 경우
			else {
				System.out.println(good);
			}
			break;
		}
	}
	
	//데이터를 삽입하는 메소드
	public void insertGood(Scanner sc) {
		while(true) {
			System.out.print("Enter Code Number : ");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println("Plz Enter Only Number");
				continue;
			}
			
			//중복 검사
			Good good = goodDAO.codeSearch(code);
			//중복된 code 이면 코드를 다시 입력하도록 설정
			if(good != null) {
				System.out.println("Already Used Number");
				continue;
			}
			
			//나머지 입력받기
			System.out.print("Enter Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Production Site : ");
			String manufacture = sc.nextLine();
			int price = -1;
			while(true) {
				System.out.print("Enter Price : ");
				input = sc.nextLine();
				try {
					price =Integer.parseInt(input);
				}catch(Exception e) {
					System.out.println("Plz Enter Only Number");
				}
				break;
			}
			//호출할 DAO 메소드의 매개변수를 생성
			good = new Good();
			good.setCode(code);
			good.setName(name);
			good.setManufacture(manufacture);
			good.setPrice(price);
			
			//DAO의 메소드 호출
			int r = goodDAO.insertGood(good);
			
			//결과 확인
			if(r >= 1) {
				System.out.println("Data Insert Success");
			}else {
				System.out.println("Data Insert Fail");
			}
			break;
		}
	}
	
	//데이터를 수정하는 메소드
	public void updateGood(Scanner sc) {
		while(true) {
			System.out.print("Enter Code Number : ");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println("Plz Enter Only Number");
				continue;
			}
			//데이터 존재 여부 확인
			Good good = goodDAO.codeSearch(code);
			if(good == null) {
				System.out.println("404 Data Not Found");
				continue;
			}
			System.out.println("Enter Name (Original Name : " + good.getName() + ") : ");
			String name = sc.nextLine();
			System.out.println("Enter Manufacture (Original MF : " + good.getManufacture() + ") : ");
			String manufacture = sc.nextLine();
			
			int price = -1;
			while(true) {
				System.out.print("Enter Price (Original Price : " + good.getPrice() + ") : ");
				input = sc.nextLine();
				try {
					price = Integer.parseInt(input);
				}catch(Exception e) {
					System.out.println("Plz Enter Only Number");
					continue;
				}
				break;
			}
			//DAO가 사용할 매개변수를 생성
			good = new Good(code, name, manufacture, price);
			
			int r = goodDAO.updateGood(good);
			
			//수정을 할 때는 0보다 where 절에 맞는 데이터가 없음
			//1 이상이면 수정한 데이터가 존재
			if(r >= 1) {
				System.out.println("Update Success");
			}else {
				System.out.println("Update Fail");
			}
			break;
		}
	}
	
	//데이터를 삭제하는 메소드
	public void deleteGood(Scanner sc) {
		while(true) {
			//삭제할 코드 입력
			System.out.println("삭제할 코드 입력:");
			String input = sc.nextLine();
			int code = -1;
			try {
				code = Integer.parseInt(input);
			}catch(Exception e) {
				System.out.println("코드는 정수로 입력하세요.");
				continue;
			}
			//데이터의 존재 여부 확인
			Good good = goodDAO.codeSearch(code);
			if(good == null) {
				System.out.println("존재하지 않는 코드입니다.");
				//메인 화면으로 이동
				return;
			}
			
			System.out.print("정말로 삭제(1:삭제 2:취소)");
			input = sc.nextLine();
			if(input.contentEquals("1")) {
				
				try {
					goodDAO.deleteGood(code);	
					System.out.println("데이터 삭제 성공");
				}catch(Exception e) {
					System.out.println("데이터 삭제 실패");
				}
				//int r = goodDAO.deleteGood(code);
				
			}
					
			
			break;
		}
	}
}
