package jp.co.systena.tigerscave.springtest.application.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.springtest.application.model.Cart;
import jp.co.systena.tigerscave.springtest.application.model.ListForm;
import jp.co.systena.tigerscave.springtest.application.model.ListService;
import jp.co.systena.tigerscave.springtest.application.model.Order;

@Controller
public class ListController {

  @Autowired
  HttpSession session;

  ListService listService = new ListService();

  @RequestMapping(value="/" , method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav) {

    ListForm listForm = (ListForm) session.getAttribute("form");
    session.removeAttribute("form");
    if (listForm != null) {
      mav.addObject("message", "商品をカートに追加しました。");
    }
    mav.addObject("listform", new ListForm());

    // 商品カート
    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }
    mav.addObject("cartlist", cart.getOrdarList());

    mav.addObject("itemlist", listService.getItemList());

    mav.setViewName("ListView");
    return mav;
  }

  @RequestMapping(value="/" , method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav,@Valid ListForm listForm) {


    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }

    Order order = new Order();
    order.setItemId(listForm.getItemId());
    order.setNum(listForm.getNum());
    cart.getOrdarList().add(order);

    session.setAttribute("form", listForm);
    session.setAttribute("cart", cart);
    return new ModelAndView("redirect:/");
  }
}
