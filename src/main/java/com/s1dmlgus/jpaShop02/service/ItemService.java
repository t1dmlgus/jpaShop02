package com.s1dmlgus.jpaShop02.service;


import com.s1dmlgus.jpaShop02.domain.Item.Item;
import com.s1dmlgus.jpaShop02.domain.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;


    // 상품등록
    public void save(Item item) {
        itemRepository.save(item);
    }

    // 전체 상품조회
    public List<Item> findItem(){
        return itemRepository.findAll();
    }



}
