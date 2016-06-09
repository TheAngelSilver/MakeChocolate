package make.chocolate;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Corey Shaw on 6/3/2016.
 */
@RestController
public class MakeChocolateJsonController {

    MakeChocolateContainer makeChocolateContainer;

    @RequestMapping(path = "/home.json", method = RequestMethod.GET)
    public MakeChocolateContainer jsonHome() {
        // Just an example and not actually useful!
        System.out.println("I'm here in jsonHome()...");
        makeChocolateContainer = new MakeChocolateContainer();
        makeChocolateContainer.setBigBarsUsed(17);
        makeChocolateContainer.setSmallBars(5);

        return makeChocolateContainer;
    }

    @RequestMapping(path = "/makeChocolate.json", method = RequestMethod.POST)
    public MakeChocolateContainer makeChocolate(Model model,HttpSession session, @RequestBody ChocolateRequestContainer chocolateRequestContainer) {
        System.out.println("I'm here in makeChocolate()...");
        MakeChocolate makeChocolate = new MakeChocolate();
        MakeChocolateContainer newMakeContainer = makeChocolate.makeChocolate(chocolateRequestContainer.getSmallBars(),
                chocolateRequestContainer.getBigBars(),
                chocolateRequestContainer.getDesiredAmount());
        return newMakeContainer;
    }
}