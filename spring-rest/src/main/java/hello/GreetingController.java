package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value="/greeting1", produces={"application/json", "application/xml"})
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "default World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, "default", name));
	}

	@PostMapping("/greeting2")
	public Greeting postGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, "post", name));
	}

	@GetMapping(value="/greeting3", produces={"application/json", "application/xml"})
	public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, "get", name));
	}
}
