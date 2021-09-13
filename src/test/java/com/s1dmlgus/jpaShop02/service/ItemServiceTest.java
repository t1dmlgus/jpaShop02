package com.s1dmlgus.jpaShop02.service;

import com.s1dmlgus.jpaShop02.domain.Item.Item;
import com.s1dmlgus.jpaShop02.domain.Item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ItemServiceTest {

    @Autowired
    public ItemService itemService;
    @Autowired
    public ItemRepository itemRepository;

    @DisplayName("상품 등록 테스트")
    @Test
    public void testSaveItem() throws Exception{
        //given
        Item item = new Item();
        item.setName("컵");
        item.setPrice(2000);

        //when
        itemService.save(item);
        
        //then
        assertThat(itemRepository.findOne(1L)).isEqualTo(item);
    }

}