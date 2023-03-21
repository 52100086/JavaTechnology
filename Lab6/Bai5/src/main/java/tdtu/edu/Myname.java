package tdtu.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:application.properties")
public class Myname {
    @Value("${my.property}")
    private String myProp;

    public String getMyProp() {
        return myProp;
    }
}
