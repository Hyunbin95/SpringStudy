package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import db.Good;
import db.GoodService;

public class Main {

	public static void main(String[] args) {
		try(GenericXmlApplicationContext context =
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");
				){
			/*
			CollectionBean bean =
					context.getBean(
							"collectionBean", CollectionBean.class);
							*/
			GoodService goodService = 
					context.getBean("goodService", GoodService.class);
			Good good = goodService.get();
			System.out.println(good);
			
		}catch(Exception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
