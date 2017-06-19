package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        StringBuffer buffer = new StringBuffer("Hello Docker World");
        buffer.append("<br>");
        buffer.append("=============================================");
        buffer.append("<br><br><br>");

        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            buffer.append(String.format("%s=%s%n",
                    envName,
                    env.get(envName)));
            buffer.append("<br>");
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
