package com.project.stilgalleriet.models;

public enum ECategory {
    DRESS, SKIRT, SHIRT, PANTS, SWEATER, SHORTS, COAT, JACKET, SUIT, JEANS;

    public static ECategory fromString(String text){
        for (ECategory category: ECategory.values()){
            if (category.name().equalsIgnoreCase(text)){
                return category;
            }
        }
        return null;
    }
}
