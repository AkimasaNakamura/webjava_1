package jp.co.systena.tigerscave.springtest.application.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品カート
 * @author systena
 *
 */
public class Cart {

  // 商品リスト
  private List<Order> ordarList = new ArrayList<Order>();

  public List<Order> getOrdarList() {
    return ordarList;
  }

  public void setOrdarList(List<Order> ordarList) {
    this.ordarList = ordarList;
  }
}
