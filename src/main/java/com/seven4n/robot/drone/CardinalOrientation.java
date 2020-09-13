package com.seven4n.robot.drone;

public enum CardinalOrientation {
    N(1, 0),
    O(0, -1),
    S(-1, 0),
    E(0, 1);

    static {
        N.left = CardinalOrientation.O;
        N.right = CardinalOrientation.E;
        O.left = CardinalOrientation.S;
        O.right = CardinalOrientation.N;
        S.left = CardinalOrientation.E;
        S.right = CardinalOrientation.O;
        E.left = CardinalOrientation.N;
        E.right = CardinalOrientation.S;
    }

    CardinalOrientation left;
    CardinalOrientation right;
    int yIncrement;
    int xIncrement;

    CardinalOrientation(int yIncrement, int xIncrement) {
        this.yIncrement = yIncrement;
        this.xIncrement = xIncrement;
    }
}
