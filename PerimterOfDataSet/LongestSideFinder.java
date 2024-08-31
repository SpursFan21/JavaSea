import java.util.*;

public class LongestSideFinder {

    public static void main(String[] args) {
        // Dataset of points
        String dataset = "-3,3 -4,-3 4,-2 6,5";

        // Parse the points from the dataset
        List<Point> points = parsePoints(dataset);

        // Find the longest side
        double longestSide = findLongestSide(points);

        // Print the longest side
        System.out.printf("The longest side of the shape is %.2f\n", longestSide);
    }

    private static List<Point> parsePoints(String dataset) {
        List<Point> points = new ArrayList<>();
        String[] pointStrings = dataset.split("\\s+");

        for (String pointString : pointStrings) {
            if (!pointString.contains(",")) {
                System.out.println("Invalid input. Please enter in the format x,y.");
                continue;
            }

            String[] coords = pointString.split(",");
            if (coords.length != 2) {
                System.out.println("Invalid input. Please enter in the format x,y.");
                continue;
            }

            try {
                int x = Integer.parseInt(coords[0].trim());
                int y = Integer.parseInt(coords[1].trim());
                points.add(new Point(x, y));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers for x and y.");
            }
        }

        return points;
    }

    private static double findLongestSide(List<Point> points) {
        if (points.size() < 2) {
            return 0; // Longest side is 0 for less than 2 points
        }

        double longestSide = 0;
        int numberOfPoints = points.size();
        
        for (int i = 0; i < numberOfPoints; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % numberOfPoints); // Next point, wrapping around to the first point
            double length = p1.distanceTo(p2);
            if (length > longestSide) {
                longestSide = length;
            }
        }

        return longestSide;
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        int dx = other.x - this.x;
        int dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
