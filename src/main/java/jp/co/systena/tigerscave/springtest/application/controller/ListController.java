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
import jp.co.systena.tigerscave.springtest.application.model.Order;

@Controller
public class ListController {

  @Autowired
  HttpSession session;

  @RequestMapping(value="/" , method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav) {

    // 商品フォーム
    ListForm listForm = (ListForm)session.getAttribute("form");
    session.removeAttribute("form");

    if(listForm != null) {
      mav.addObject("massage" ,"商品をカートに追加しました。");
    }
    mav.addObject("listForm", new ListForm());

    // 商品カート
    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }
    mav.addObject("cartlist", cart.getOrdarList());

    // サンプル:bindingResultで入力値の検証を行っている。

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
    order.setItemId(listForm.getItem().getItemId());
    order.setNum(listForm.getSum());
    cart.getOrdarList().add(order);

    session.setAttribute("form", listForm);
    return new ModelAndView("redirect:/");
  }



}
