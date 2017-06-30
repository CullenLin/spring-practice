package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("abc")
@Scope("prototype")   // default is singleton
public class MessagePrinter {
	@Autowired
	private MessageService service;

    public MessagePrinter() {
    	System.out.println("creating Message Printer");
	}
    
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
