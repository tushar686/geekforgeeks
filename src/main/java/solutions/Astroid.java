package solutions;

import java.util.*;

/*
              .   O     〇      o     #=#  <- space station
              →   ←     →       ←

mass          1   5     7       3
direction     1  -1     1      -1

answer: 1

              .   o   O   〇   #=#
              →   →   →   ←

mass          1   3   5   7
direction     1   1   1  -1


count = 1
0 to n
//min right [1, 3, 5]
max right = 5
max left = 7

answer: 0

              O   .   o   #=#
              →   →   ←

mass          5   1   4
direction     1   1  -1

//min right [5, 1]
//max right = 5
//max left = 4

answer: 1

              .   O   o   #=#
              →   →   ←

mass          1   5   4
direction     1   1  -1

answer: 2
*/

public class Astroid {

    class Asteroid {
        public final int mass;
        public final int direction;
        public Asteroid(int mass, int direction) {
            this.mass = mass;
            this.direction = direction;
        }

        public int getMass() {
            return this.mass;
        }

        public int getDirection() {
            return this.direction;
        }

        public String toString() {
            return "Asteroid(" + mass + ", " + direction + ")";
        }
    }

    public static void main(String[] args) {
        new Astroid().test(new String[]{});
    }

    public void test(String[] args) {
        Asteroid[] case1 = new Asteroid[] {
                new Asteroid(1, 1),
                new Asteroid(5, -1),
                new Asteroid(7, 1),
                new Asteroid(3, -1),
        };

        Asteroid[] case2 = new Asteroid[] {
                new Asteroid(1, 1),
                new Asteroid(3, 1),
                new Asteroid(5, 1),
                new Asteroid(7, -1),
        };

        Asteroid[] case3 = new Asteroid[] {
                new Asteroid(5, 1),
                new Asteroid(1, 1),
                new Asteroid(4, -1),
        };

        Asteroid[] case4 = new Asteroid[] {
                new Asteroid(1, 1),
                new Asteroid(5, 1),
                new Asteroid(4, -1),
        };


        testCase(1, case1, 1);
        testCase(2, case2, 0);
        testCase(3, case3, 1);
        testCase(4, case4, 2);
    }

    static void testCase(int caseNum, Asteroid[] asteroids, int expected) {
        int result = countHits(asteroids);
        System.out.print("Case " + caseNum + ": ");
        if (result == expected) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED: got " + result + " expected " + expected);
        }
    }


    static int countHits(Asteroid[] asteroids) {
        List<Asteroid> rightMass = new LinkedList<>();

        int maxLeftMass = 0;

        for (Asteroid asteroid : asteroids) {
            if (asteroid.getDirection() < 0) {
                if (maxLeftMass < asteroid.getMass()) {
                    maxLeftMass = asteroid.getMass();
                }
            } else {
                rightMass.add(asteroid);
            }

            if (willLeftBeDistroyed(rightMass, maxLeftMass) ) {
                maxLeftMass = 0;
            }

        }

        System.out.println(rightMass.size());
        return rightMass.size(); // TODO
    }

    static boolean willLeftBeDistroyed(List<Asteroid> rightMassList, int maxLeftMass) {

        List<Asteroid> removeList = new ArrayList<>();

        boolean willDestroyLeft = false;

        for (int i = rightMassList.size()-1; i >= 0; i--) {
            Asteroid rightMass = rightMassList.get(i);
            if (rightMass.getMass() > maxLeftMass) {
                willDestroyLeft = true;
                break;
            } else {
                removeList.add(rightMass);
            }
        }

        for (Asteroid removeMe : removeList) {
            rightMassList.remove(removeMe);
        }


        return willDestroyLeft;
    }
}
