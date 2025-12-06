package org.dewOps.DecoratorDesginPattern;

public class MargaritaPizza implements  BasePizza{

    @Override
    public String description() {
        return "BasePizza MargaritaPizza";
    }

    @Override
    public Integer cost() {
        return 100;
    }
}
