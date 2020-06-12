package com.study.ai.HeuristicSearch;

import java.util.ArrayList;
import java.util.List;

public class TSP{
    public static void main(String[] args) {
        List<City> path = new ArrayList<>();
        List<City> list = new ArrayList<>();
//        list.add(new City());

//        // Loop until system has cooled
//        while (temp > 1) {
//            // Create new neighbour tour
//            Tour newSolution = new Tour(currentSolution.getTour());
//
//            // Get a random positions in the tour
//            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
//            int tourPos2 = (int) (newSolution.tourSize() * Math.random());
//            while (tourPos1 == tourPos2 ) {
//                tourPos2 = (int) (newSolution.tourSize() * Math.random());
//            }
//
//            // Get the cities at selected positions in the tour
//            City citySwap1 = newSolution.getCity(tourPos1);
//            City citySwap2 = newSolution.getCity(tourPos2);
//
//            // Swap them
//            newSolution.setCity(tourPos2, citySwap1);
//            newSolution.setCity(tourPos1, citySwap2);
//
//            // Get energy of solutions
//            int currentEnergy = currentSolution.getDistance();
//            int neighbourEnergy = newSolution.getDistance();
//
//            // Decide if we should accept the neighbour
//            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
//                currentSolution = new Tour(newSolution.getTour());
//            }
//
//            // Keep track of the best solution found
//            if (currentSolution.getDistance() < best.getDistance()) {
//                best = new Tour(currentSolution.getTour());
//            }
//
//            // Cool system
//            temp *= 1-coolingRate;
//
//        }

    }
}

class City implements Comparable<City>{
    int x;
    int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double computeDistance(City o){
        int tx = Math.abs(x-o.getX());
        int ty = Math.abs(y-o.getY());
        return Math.sqrt(tx*tx+ty*ty);
    }

    @Override
    public int compareTo(City o) {
        int tx = Math.abs(x-o.getX());
        int ty = Math.abs(y-o.getY());
        double dis = Math.sqrt(tx*tx+ty*ty);
        return 0;
    }
}
