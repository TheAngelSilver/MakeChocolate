package make.chocolate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Corey Shaw on 6/3/2016.
 */

@Controller
public class MakeChocolateController {
  // public static MakeChocolateContainer makeChocolateContainer;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model mode){
        return "home";
    }

    @RequestMapping(path = "/make-chocolate", method = RequestMethod.GET)
    public String makeChocolate(HttpSession httpSession ,MakeChocolateContainer smallBars, int bigBars, int desiredAmount) {
        return "redirect:/";
    }

}
