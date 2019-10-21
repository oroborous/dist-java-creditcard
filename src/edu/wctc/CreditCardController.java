package edu.wctc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CreditCardController {
    @RequestMapping("/")
    public String showForm() {
        return "credit-form";
    }

    @RequestMapping("/done")
    public String processForm(HttpServletRequest request, Model model) {
        String cName = request.getParameter("cardName");
        String cNum = request.getParameter("cardNum");
        String eDate = request.getParameter("expDate");
        String sCode = request.getParameter("secCode");

        model.addAttribute("cardName", cName);
        model.addAttribute("cardNum", cNum);
        model.addAttribute("expDate", eDate);
        model.addAttribute("secCode", sCode);

        return "confirm";
    }

    @RequestMapping("/done2")
    public String processFormWithBinding(@RequestParam("cardName") String cName,
                                         @RequestParam String cardNum,
                                         @RequestParam("expDate") String eDate,
                                         @RequestParam String secCode,
                                         Model model) {
        model.addAttribute("cardName", cName);
        model.addAttribute("cardNum", cardNum);
        model.addAttribute("expDate", eDate);
        model.addAttribute("secCode", secCode);

        return "confirm";
    }

    @RequestMapping("/showNewForm")
    public String showBindingForm(Model model) {
        CreditCard cc = new CreditCard();
        model.addAttribute("card", cc);
        return "credit-form-binding";
    }

    @RequestMapping("/done3")
    public String processFormWithBinding2(@ModelAttribute("card") CreditCard myCard) {
        System.out.println(myCard.getName());
        System.out.println(myCard.getNumber());
        return "confirm-binding";
    }
}
