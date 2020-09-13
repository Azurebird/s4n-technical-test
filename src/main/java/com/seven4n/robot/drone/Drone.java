package com.seven4n.robot.drone;


import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class Drone implements Runnable {
    public final String name;

    private List<List<MovementType>> deliveryRoutes;

    private CardinalOrientation currentOrientation;

    private Pair<Integer, Integer> currentCoords;

    private List<String> deliveryPointsReport;

    public Drone(String name, List<List<MovementType>> deliveryRoutes) {
        this.name = name;
        this.deliveryRoutes = deliveryRoutes;
        this.currentCoords = new Pair<>(0, 0);
        this.currentOrientation = CardinalOrientation.N;
        this.deliveryPointsReport = new ArrayList<>();
    }

    @Override
    public void run() {
        for (List<MovementType> route: deliveryRoutes) {
            for (MovementType movementType: route) {
                switch (movementType) {
                    case A:
                        final Integer newXValue = currentCoords.getValue0() + currentOrientation.xIncrement;
                        final Integer newYValue = currentCoords.getValue1() + currentOrientation.yIncrement;
                        currentCoords = new Pair<>(newXValue, newYValue);
                        break;
                    case D:
                        currentOrientation = currentOrientation.right;
                        break;
                    case I:
                        currentOrientation = currentOrientation.left;
                        break;
                }
            }
            final String report = "(" + currentCoords.getValue0() + ", " + currentCoords.getValue1() + ") " + currentOrientation.name();
            deliveryPointsReport.add(report);
        }
    }

    public List<String> getDeliveryPointsReport() {
        return new ArrayList<>(deliveryPointsReport);
    }
}