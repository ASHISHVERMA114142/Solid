package org.dewOps.DecoratorDesginPattern;

public class Mashroom implements TopingDecoder{
    private BasePizza basePizza;
    Mashroom(BasePizza basePizza){
        this.basePizza=basePizza;
    }
    @Override
    public String description() {
        return basePizza.description()+" Mashroom";
    }

    @Override
    public Integer cost() {
        return basePizza.cost()+30;
    }
}
