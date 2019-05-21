package di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CollectionBean {
	// < >을 Generic 또는 템플릿 프로그래밍 이라고 하는데 
	//미리 자료형을 결정하지 않고 객체가 만들어질 자료형을 결정하기 위한
	//프로그래밍 방식
	//알고리즘은 동일한데 대입되는 데이터에 따라 매번 다시 메소드들을 구현하는 것이 번거로워서 사용
	private List<String> list;
	private Set<String> set;
	private Map<String, Object> map;
	private Properties prop;
	
	
	
	public CollectionBean() {
		super();
	}
	public CollectionBean(List<String> list, Set<String> set, Map<String, Object> map, Properties prop) {
		super();
		this.list = list;
		this.set = set;
		this.map = map;
		this.prop = prop;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	
}
