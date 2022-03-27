package com.fruit.dao;

import com.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
 List<Fruit> getFruitList(String keyword,Integer pageNo);
 Fruit getFruitByID( Integer fid);
 void updateFruit(Fruit fruit);
 void delFruit(Integer fid);
 void addFruit(Fruit fruit);
 int getFruitCount( String keyword);
}
