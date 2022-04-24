package main;

import config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductDeliveryService;


public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        ProductDeliveryService service = context.getBean(ProductDeliveryService.class);
        service.addSomeProducts();

    }
}
