package spring.demo.async;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAsyncDemo {

	public static void main(String[] args) throws InterruptedException {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("async-context.xml");
			
			HelloInterface helloGuys = context.getBean(HelloInterface.class);
			for (int i=0; i<10; i++) {
				helloGuys.sayHello(i);
			}
			
			helloGuys.sayHelloEverySecondes();
			
			System.out.println("goodbye");
			Thread.sleep(10000);
			
			context.close();
	}
}
