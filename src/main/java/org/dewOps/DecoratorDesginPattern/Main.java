package org.dewOps.DecoratorDesginPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import  java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("DecoratorDesginPattern");
        Map<String, Function<BasePizza,BasePizza>> checkList= Map.of(
                "Mashroom",Mashroom::new,
                "ExtraCheese",ExtraCheese::new
        );
        Map<String, Supplier<BasePizza>> basePizzaMap=Map.of(
                "MargaritaPizza",MargaritaPizza::new,
                "VegDelight",VegDelight::new
        );
        List<String> customerChoice=new ArrayList<>(Arrays.asList("Mashroom","ExtraCheese"));
        BasePizza basePizza= basePizzaMap.get("MargaritaPizza").get();
        for(String choice:customerChoice){
            System.out.println("this is "+choice);
            basePizza=checkList.get(choice).apply(basePizza);
        }
        System.out.println(basePizza.description());
        System.out.println(basePizza.cost());


    }
}
