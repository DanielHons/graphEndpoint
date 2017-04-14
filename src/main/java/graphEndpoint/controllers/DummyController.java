package graphEndpoint.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Daniel on 14.04.2017.
 */
@Controller
@RequestMapping("/dummy")
public class DummyController {

    @RequestMapping()
    @ResponseBody
    public String hello()
    {
        return "Hello";
    }
}
