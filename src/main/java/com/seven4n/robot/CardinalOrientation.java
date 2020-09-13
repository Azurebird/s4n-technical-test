package com.seven4n.robot;

/**
 * Represents a cardinal orientation with its corresponding axis modifier incrementation
 */
public enum CardinalOrientation {
    N("Norte", 1, 0),
    O("Oeste", 0, -1),
    S("Sur", -1, 0),
    E("Este", 0, 1);

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

    public String name;
    public int yIncrement;
    public int xIncrement;

    public CardinalOrientation left;
    public CardinalOrientation right;

    CardinalOrientation(String name, int yIncrement, int xIncrement) {
        this.name = name;
        this.yIncrement = yIncrement;
        this.xIncrement = xIncrement;
    }
}
