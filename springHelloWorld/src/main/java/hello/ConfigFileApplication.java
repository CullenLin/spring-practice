package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigFileApplication {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext xpContext = new ClassPathXmlApplicationContext("hello-bean.xml");
      MessagePrinter printer = (MessagePrinter) xpContext.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}
