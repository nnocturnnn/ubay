package world.ucode.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPage {
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView getdata() {
        Lot lott = new Lot();
        List<Lot> empList = new ArrayList<>();
		empList.add(lott);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("mainPage");
		mv.addObject("empList", empList);

		return mv;
    }
}
