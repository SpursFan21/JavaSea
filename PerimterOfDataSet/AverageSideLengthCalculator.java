import java.util.*;

public class AverageSideLengthCalculator {

    public static void main(String[] args) {
        // Dataset of points
        String dataset = "-3,9 -8,7 -12,4 -6,-2 -4,-6 2,-8 6,-5 10,-3 8,5 4,8";

        // Parse the points from the dataset
        List<Point> points = parsePoints(dataset);

        // Calculate the average side length
        double averageLength = calculateAverageSideLength(points);

        // Print the average side length
        System.out.printf("The average side length of the shape is %.2f\n", averageLength);
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

    private static double calculateAverageSideLength(List<Point> points) {
        if (points.size() < 2) {
            return 0; // Average length is 0 for less than 2 points
        }

        double totalLength = 0;
        int numberOfSides = points.size();
        
        for (int i = 0; i < numberOfSides; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % numberOfSides); // Next point, wrapping around to the first point
            totalLength += p1.distanceTo(p2);
        }

        return totalLength / numberOfSides;
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
