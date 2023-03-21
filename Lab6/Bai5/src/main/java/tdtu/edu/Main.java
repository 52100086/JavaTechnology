package tdtu.edu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;

@PropertySource("classpath:application.properties")
public class Main
{
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Myname.class);
        Myname name = context.getBean(Myname.class);

        System.out.println(name.getMyProp());

        context.close();
    }
}
