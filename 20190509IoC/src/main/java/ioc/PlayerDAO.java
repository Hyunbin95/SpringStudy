package ioc;

public class PlayerDAO {
	//패키지 외부에서는 객체 생성을 못하도록 생성자를 default 로 생성
	PlayerDAO(){}
	//Player 1개를 리턴해주는 메소드
	public Player getPlayer() {
		Player player = new Player();
		player.setNum(1);
		player.setName("이현빈");
		player.setEvents("junior developer");
		return player; 
	}

}
