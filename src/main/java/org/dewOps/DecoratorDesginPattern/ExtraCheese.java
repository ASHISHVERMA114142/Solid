package org.dewOps.DecoratorDesginPattern;

public class ExtraCheese implements TopingDecoder{
    private BasePizza basePizza;
    ExtraCheese(BasePizza basePizza){
        this.basePizza=basePizza;
    }

    @Override
    public String description() {
        return basePizza.description()+" extraCheese";
    }

    @Override
    public Integer cost() {
        return basePizza.cost()+20;
    }
}
