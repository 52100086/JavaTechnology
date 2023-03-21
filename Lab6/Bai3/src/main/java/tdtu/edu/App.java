package tdtu.edu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tdtu.edu.ex3.AppConfiguration;
import tdtu.edu.ex3.TextEditor;

import java.io.IOException;

public class App
{
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        TextEditor textEditor = context.getBean(TextEditor.class);

        textEditor.input("Phan Hoang Phu");
        textEditor.save("test.pdf");

    }
}
