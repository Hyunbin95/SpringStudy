package good.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//접근자 메소드, toString, hashCode, equals 메소드가 생성
@Data
//매개변수가 없는 생성자
@NoArgsConstructor
//인스턴스 변수 모두를 매개변수로 받는 생성자
@AllArgsConstructor
public class Good {

	private int code;
	private String name;
	private String manufacture;
	private int price;
}
