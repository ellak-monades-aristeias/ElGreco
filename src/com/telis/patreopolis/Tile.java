package com.telis.patreopolis;



public class Tile {
    String name;
    String tileCountry;
    private TilePanel basic;


//    Tile(String nameIn, int type) {
    Tile(String nameIn, String countryIn, int position) {
        name = nameIn;
        tileCountry = countryIn;
//        country = countryIn;
        // 1 = starting point
        // 2 = patras sights
        // 3 = question tiles
        // 4 = train tiles
        // 5 = command tiles
        // 6 = free parking tiles
        // 7 = school tiles
        // 8 = port tiles
//        if (type == 1)
//            basic = new TilePanel(name);
//        else if (type == 2)
//            basic = new TilePanel(name);
//        else if (type == 3)
//            basic = new TilePanel(name);
//        else if (type == 4)
//            basic = new TilePanel(name);
//        else if (type == 5)
//            basic = new TilePanel(name);
//        else if (type == 6)
//            basic = new TilePanel(name);
//        else if (type == 7)
//            basic = new TilePanel(name);
//        else if (type == 8)
//            basic = new TilePanel(name);
//        else
            basic = new TilePanel(name, tileCountry, position);
    }

    public TilePanel getTilePanel() {
        return basic;
    }
}
