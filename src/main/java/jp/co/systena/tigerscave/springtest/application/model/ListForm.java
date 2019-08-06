package jp.co.systena.tigerscave.springtest.application.model;

import java.util.ArrayList;

/**
 *商品リストフォーム
 * @author systena
 *
 */
public class ListForm {

  private ArrayList<Item> items;
  private int num;
  public ArrayList<Item> getItems() {
    return items;
  }
  public void setItems(ArrayList<Item> items) {
    this.items = items;
  }
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }



//  private String name;
//  private int num;
//
//  public ListForm(String name) {
//    this.name = name;
//    this.num = 0;
//  }
//
//
//  public String getName() {
//    return name;
//  }
//  public void setName(String name) {
//    this.name = name;
//  }
//  public int getNum() {
//    return num;
//  }
//  public void setNum(int num) {
//    this.num = num;
//  }

}
