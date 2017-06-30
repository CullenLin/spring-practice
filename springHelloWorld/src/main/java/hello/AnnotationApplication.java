package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AnnotationApplication {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
            	System.out.println("creating message service");
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(AnnotationApplication.class);
      MessagePrinter printer = (MessagePrinter) context.getBean(MessagePrinter.class);
      printer.printMessage();
      printer = (MessagePrinter) context.getBean("abc");
      printer.printMessage();
      
  }
}
