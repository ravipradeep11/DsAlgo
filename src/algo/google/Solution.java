package algo.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {







    public void cleanRoom(Robot robot) {
        HashSet<Point> visited=new HashSet<>();
        Queue<Point> queue=new LinkedList<>();
        Point p=new Point(0,0);
        visited.add(p);
        queue.add(p);

        while(!queue.isEmpty()){

            Point point=queue.remove();


        }

    }

    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


     static  interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
          // Returns false if the cell in front is blocked and robot stays in the current cell.
          public boolean move();

          // Robot will stay in the same cell after calling turnLeft/turnRight.
         // Each turn will be 90 degrees.
        public void turnLeft();
         public void turnRight();
        // Clean the current cell.
         public void clean();
      }

}
