package com.pluralsight.finance;

import java.util.ArrayList;
import java.util.Collections;

public class Portfolio {
    private String name;
    private String owner;
    private static ArrayList<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }
    public static void add(Valuable asset) {
        assets.add(asset);
    }
    public static double getValue(){
        double totalValue = 0;
        for(Valuable asset : assets){
            totalValue += asset.getValue();

        }
        return totalValue;
    }
    public static Valuable getMostValuable(){
        if(assets.isEmpty()){
            return null;
        }
        Valuable mostValuableAsset = assets.get(0);
        double highestValue = mostValuableAsset.getValue();

        for(Valuable asset : assets){
            double assetValue = asset.getValue();
            if(assetValue > highestValue){
                highestValue = assetValue;
                mostValuableAsset = asset;
            }
        }
        return mostValuableAsset;
    }
    public static Valuable getLeastValuable(){
        if(assets.isEmpty()){
            return null;
        }
        Valuable leastValuableAsset = assets.get(0);
        double lowestValue = leastValuableAsset.getValue();

        for(Valuable asset : assets){
            double assetValue = asset.getValue();
            if(assetValue < lowestValue){
                lowestValue = assetValue;
                leastValuableAsset = asset;
            }
        }
        return leastValuableAsset;
    }
}
