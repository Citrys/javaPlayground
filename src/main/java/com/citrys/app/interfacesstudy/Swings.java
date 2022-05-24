package com.citrys.app.interfacesstudy;

interface Swings {
    int NORTH = 1;
    int WEST = 2;
    int NORTH_WEST = 3;
}

class Swinger implements Swings {
    public int getDirection(int direction) {
        if (direction == 2) {
            return NORTH;
        }
        return 0;
    }
}
