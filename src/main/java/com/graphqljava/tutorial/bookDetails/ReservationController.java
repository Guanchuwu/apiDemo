package com.graphqljava.tutorial.bookDetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Controller
public class ReservationController {
    @QueryMapping
    public Reservation getMatchedReservation(@Argument ItemList itemList) {
        List<Item> items = Arrays.asList(itemList.getItems());
        if (items == null) {
            System.out.println("toothless: item is null");
        }
        else if (items.size()==0) {
            System.out.println("item is empty");
        }
        else {
            System.out.println("ListItems confirNumb: " + items.get(0).getConfirmationNumber());
            System.out.println("ListItems partId: " + items.get(0).getPartnerId());
        }

        List<String> resId = new ArrayList<>();
        for (Item item : items) {
            String res = item.getPartnerId()+item.getConfirmationNumber();
            System.out.println("resId res ="+res);
            resId.add(res);
        }

        System.out.println("resId="+resId.get(0));
        return new Reservation(resId);
    }
}
