package monicalhamilton.ctci.recursionanddp;

import java.util.*;

/**
 * 9.2
 *
 * Imagine a robot sitting on the upper left comer of an X by Y grid. The robot can only move in two directions: right
 * and down. How many possible paths are there for the robot togofrom (0,0) to (X, Y)?
 *
 * FOLLOW UP
 *
 * Imagine certain spots are "off limits," such that the robot cannot step on them. Design an algorithm to find a path
 * for the robot from the top left to the bottom right.
 */
public class FindPathInGrid {

    private final Collection<Coordinate> blockedSquares;
    private final int width;
    private final int height;
    private final Map<Coordinate, DirectionResult> cachedDirections = new HashMap<>();
    private final Coordinate destination;

    public FindPathInGrid(int width, int height, Collection<Coordinate> blockedSquares) {
        this.blockedSquares = blockedSquares;
        this.width = width;
        this.height = height;
        this.destination = new Coordinate(width - 1, height - 1);
    }

    public static class DirectionResult {
        List<Direction> directions;
        private boolean found;

        public DirectionResult(List<Direction> directions, boolean found) {
            this.directions = directions;
            this.found = found;
        }

        public static DirectionResult found(List<Direction> directions) {
            return new DirectionResult(directions, true);
        }

        public static DirectionResult notFound() {
            return new DirectionResult(new ArrayList<>(), false);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DirectionResult that = (DirectionResult) o;
            return found == that.found &&
                    Objects.equals(directions, that.directions);
        }

        @Override
        public int hashCode() {

            return Objects.hash(directions, found);
        }

        @Override
        public String toString() {
            return "DirectionResult{" +
                    "directions=" + directions +
                    ", found=" + found +
                    '}';
        }
    }

    public DirectionResult findPath() {
        Coordinate start = new Coordinate(0, 0);
        if (isAvailable(start)) {
            return findPath(start);
        }
        return DirectionResult.notFound();
    }

    private DirectionResult findPath(Coordinate input) {
        if (input.equals(destination)) {
            return DirectionResult.found(new ArrayList<>());
        }
        if (cachedDirections.containsKey(input)) {
            return cachedDirections.get(input);
        }

        Coordinate right = input.getRight();
        Coordinate down = input.getDown();

        if (isAvailable(right)) {
            DirectionResult directionsFromRight = findPath(right);
            if (directionsFromRight.found) {
                List<Direction> directions = new ArrayList<>();
                directions.add(Direction.RIGHT);
                directions.addAll(directionsFromRight.directions);
                DirectionResult found = DirectionResult.found(directions);
                cachedDirections.put(input, found);
                return found;
            }
        } else if (isAvailable(down)) {
            DirectionResult directionsFromDown = findPath(down);
            if (directionsFromDown.found) {
                List<Direction> directions = new ArrayList<>();
                directions.add(Direction.DOWN);
                directions.addAll(directionsFromDown.directions);
                DirectionResult found = DirectionResult.found(directions);
                cachedDirections.put(input, found);
                return found;
            }
        }
        return DirectionResult.notFound();
    }

    private boolean isAvailable(Coordinate coordinate) {
        if (blockedSquares.contains(coordinate)) {
            return false;
        }
        return coordinate.x < width && coordinate.y < height;
    }

    public enum Direction {
        DOWN,
        RIGHT
    }

    public static class Coordinate {
        private int x;
        private int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Coordinate getRight() {
            return new Coordinate(x + 1, y);
        }

        Coordinate getDown() {
            return new Coordinate(x, y + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
