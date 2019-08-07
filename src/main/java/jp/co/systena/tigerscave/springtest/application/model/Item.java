package jp.co.systena.tigerscave.springtest.application.model;

/**
 * 商品
 * @author systena
 *
 */
public class Item {

  private int itemId;
  private String name;
  private int price;

  /**
   * コンストラクタ
   * @param itemId 商品ID
   * @param name   商品名
   * @param price  価格
   */
  public Item(int itemId,String name,int price) {
    this.itemId = itemId;
    this.name = name;
    this.price = price;
  }

  public int getItemId() {
    return itemId;
  }
  public void setItemId(int itemId) {
    this.itemId = itemId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
}
