package hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.Manifest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigFileApplication {

//    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) throws FileNotFoundException, IOException {
	  System.out.println(System.getProperty("java.io.tmpdir"));
	  File root = new File(new ConfigFileApplication().getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
	  File metainfo = new File(root, "META-INF");
	  File manifest = new File(metainfo, "MANIFEST.MF");
	  
	  Manifest mf = new Manifest(new FileInputStream(manifest));
	  System.out.println(mf.getEntries().size());
	  
      ApplicationContext xpContext = new ClassPathXmlApplicationContext("hello-bean.xml");
      MessagePrinter printer = (MessagePrinter) xpContext.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}
