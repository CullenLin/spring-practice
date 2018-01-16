package spring.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements HelloInterface {

	@Async
	public void sayHello(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the " + i + " time to say " + "userHello");

	}

	@Scheduled(fixedDelay=1000)
	public void sayHelloEverySecondes() {
		System.out.println("say hello at timestamp " + System.currentTimeMillis());

	}

}
