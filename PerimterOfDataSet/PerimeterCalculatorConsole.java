import java.util.*;

public class PerimeterCalculatorConsole {

    public static void main(String[] args) {
        // Example datasets
        String dataset1 = "-3,3 -4,-3 4,-2 6,5";
        String dataset2 = "-3,9 -8,7 -12,4 -6,-2 -4,-6 2,-8 6,-5 10,-3 8,5 4,8";
        
        // Process and print perimeter for each dataset
        List<Point> points1 = parsePoints(dataset1);
        List<Point> points2 = parsePoints(dataset2);
        
        double perimeter1 = calculatePerimeter(points1);
        double perimeter2 = calculatePerimeter(points2);
        
        System.out.println("Dataset 1 Points: " + dataset1);
        System.out.printf("Perimeter 1: %.2f\n", perimeter1);
        
        System.out.println("Dataset 2 Points: " + dataset2);
        System.out.printf("Perimeter 2: %.2f\n", perimeter2);
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

    private static double calculatePerimeter(List<Point> points) {
        double perimeter = 0;
        int numberOfPoints = points.size();
        
        if (numberOfPoints < 2) {
            return perimeter; // Perimeter is 0 for less than 2 points
        }
        
        for (int i = 0; i < numberOfPoints; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % numberOfPoints); // Next point, wrapping around to the first point
            perimeter += p1.distanceTo(p2);
        }
        
        return perimeter;
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
