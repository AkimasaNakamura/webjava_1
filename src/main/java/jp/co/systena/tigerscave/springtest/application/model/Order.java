package jp.co.systena.tigerscave.springtest.application.model;

/**
 * 注文オーダー
 * @author systena
 *
 */
public class Order {

  /**
   * itemId 商品ID(PK)
   * num    注文個数
   */
  private int itemId;
  private int num;

  public int getItemId() {
    return itemId;
  }
  public void setItemId(int itemId) {
    this.itemId = itemId;
  }
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
}
