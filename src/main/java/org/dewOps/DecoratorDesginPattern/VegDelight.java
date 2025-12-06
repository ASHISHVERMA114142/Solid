package org.dewOps.DecoratorDesginPattern;

public class VegDelight implements BasePizza{

    @Override
    public String description() {
        return "BasePizza vegDelight";
    }

    @Override
    public Integer cost() {
        return 120;
    }
}
