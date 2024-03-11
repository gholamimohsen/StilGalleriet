package com.project.stilgalleriet.models;

public enum ESize {
  XSMALL, SMALL, MEDIUM, LARGE, XLARGE;

    public static ESize fromString(String text){
        for (ESize size: ESize.values()){
            if (size.name().equalsIgnoreCase(text)){
                return size;
            }
        }
        return null;
    }
}
