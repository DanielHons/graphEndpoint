/**
 * Created by Daniel on 12.04.2017.
 *
 * Spring main class
 */

package graphEndpoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@SpringBootApplication
@EnableAutoConfiguration
public class MainApp {



    @RequestMapping(method= RequestMethod.GET)
    protected  @ResponseBody String sample(){

        return "Test";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApp.class, args);
    }
}
