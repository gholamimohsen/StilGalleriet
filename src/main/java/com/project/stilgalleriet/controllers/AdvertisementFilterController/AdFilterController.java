package com.project.stilgalleriet.controllers.AdvertisementFilterController;

import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/advertisements")
public class AdFilterController {

    @Autowired
    private AdvertisementFilterService advertisementFilterService;



    @GetMapping("/filter") // new endpoint for all filter functions --Strategi Pattern--
    public List<Advertisement> filterAdvertisements(@RequestParam("filterType") String filterType,
                                                    @RequestParam Map<String, String> params) {
        AdvertisementFilterStrategy strategy = getFilterStrategy(filterType, params);
        return strategy.filterAdvertisements(advertisementFilterService);
    }

    private AdvertisementFilterStrategy getFilterStrategy(String filterType, Map<String, String> params) {
        switch (filterType) {
            case "color":
                String color = params.get("color");
                return new AdFilterByColor(color);
            case "gender":
                String gender = params.get("gender");
                return new AdFilterByGender(gender);
            case "size":
                String size = params.get("size");
                return new AdFilterBySize(size);
            case "category":
                String category = params.get("category");
                return new AdFilterByCategory(category);
            case "priceGreaterThan":
                double minPrice = Double.parseDouble(params.get("minPrice"));
                return new AdFilterByMinPrice(minPrice);
            case "priceBetween":
                double minPrice2 = Double.parseDouble(params.get("minPrice"));
                double maxPrice2 = Double.parseDouble(params.get("maxPrice2"));
                return new AdFilterByPriceBetween(minPrice2, maxPrice2);
            case "priceLessThan":
                double maxPrice = Double.parseDouble(params.get("maxPrice"));
                return new AdFilterByMaxPrice(maxPrice);
            case "createdBefore":
                String dateStringBefore = params.get("date");
                return new AdFilterByDateBefore(dateStringBefore);
            case "createdAfter":
                String dateStringAfter = params.get("date");
                return new AdFilterByDateAfter(dateStringAfter);
            default:
                throw new IllegalArgumentException("Unknown filter type");

        }
    }
}
