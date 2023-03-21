package tdtu.edu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tdtu.edu.ex4.TextEditor;

import java.io.IOException;
@Configuration
@ComponentScan(basePackages = "tdtu.edu.ex4")
public class App
{
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        TextEditor textEditor = context.getBean(TextEditor.class);

        textEditor.input("hello");
        textEditor.save("test.pdf");

        context.close();
    }
}
