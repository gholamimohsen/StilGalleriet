package com.project.stilgalleriet.models;

public enum ESize {
    XSMALL, SMALL, MEDIUM, LARGE, XLARGE,

    //  can be deleted these
    EU_32, EU_34, EU_36, EU_38, EU_40, EU_42, EU_44, EU_46, EU_48, EU_50, EU_52, EU_54, EU_56, EU_58, EU_60;

    public static ESize fromString(String text){
        for (ESize size: ESize.values()){
            if (size.name().equalsIgnoreCase(text)){
                return size;
            }
        }
        return null;
    }


}
