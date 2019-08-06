package jp.co.systena.tigerscave.springtest.application.model;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 * 商品一覧
 * @author systena
 *
 */
@Service
public class ListService {

  private ArrayList<Item> itemList;

  public ArrayList<Item> getItemList() {

    itemList.add(new Item(000, "apple", 100));
    itemList.add(new Item(001, "orange", 110));
    itemList.add(new Item(002, "grapes", 200));
    itemList.add(new Item(003, "melon", 500));

    return itemList;
  }

}
