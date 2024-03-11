package com.project.stilgalleriet.models;

public enum EColor {
    BLACK, BLUE, PINK, RED, BROWN, WHITE, YELLOW, GREEN, ORANGE, GRAY, MIX;

    public static EColor fromString(String text){
        for (EColor color: EColor.values()){
            if (color.name().equalsIgnoreCase(text)){
                return color;
            }
        }
        return null;
    }


}
