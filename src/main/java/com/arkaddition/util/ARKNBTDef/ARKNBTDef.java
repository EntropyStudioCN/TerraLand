package com.arkaddition.util.ARKNBTDef;


public enum ARKNBTDef {
    //ALL
    ARK_JOB("ARK_JOB"),
    ARK_STRENGTH("ARK_STRENGTH"),
    ARK_STRENGTH_MAX("ARK_STRENGTH_MAX"),
    ;
    private String name;
    ARKNBTDef(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
