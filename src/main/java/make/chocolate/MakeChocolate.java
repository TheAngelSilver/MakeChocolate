package make.chocolate;

/**
 * Created by Corey Shaw on 6/3/2016.
 */
public class MakeChocolate {
    public  MakeChocolateContainer makeChocolateContainer = new MakeChocolateContainer();

    public MakeChocolateContainer makeChocolate(int small, int big, int goal) {
        /*CodingBat.com Logic 2>makeChocolate
          We want make a package of goal kilos of chocolate.
          We have small bars (1 kilo each) and big bars (5 kilos each).
          Return the number of small bars to use, assuming we always use big bars before small bars.
          Return -1 if it can't be done.
         */
        //small =  goal% big*5;
        if (goal > big * 5 + small) {
            makeChocolateContainer.setNoSolution();
        }
        makeChocolateContainer.totalBarsUsed= 0;
        makeChocolateContainer.bigBarsUsed = 0;
        while (makeChocolateContainer.totalBarsUsed < goal && makeChocolateContainer.bigBarsUsed < big ) {
            makeChocolateContainer.totalBarsUsed = makeChocolateContainer.totalBarsUsed + 5;
            makeChocolateContainer.bigBarsUsed++ ;
        }
        if (makeChocolateContainer.totalBarsUsed == goal) {
            makeChocolateContainer.setSmallBars(0);
        }
        if (makeChocolateContainer.totalBarsUsed > goal) {
            makeChocolateContainer.totalBarsUsed = makeChocolateContainer.totalBarsUsed - 5;
            makeChocolateContainer.bigBarsUsed--;
        }
        if (goal - makeChocolateContainer.totalBarsUsed > small) {
            makeChocolateContainer.setNoSolution();
        }
        makeChocolateContainer.smallBarsUsed = goal - makeChocolateContainer.totalBarsUsed;
        if (makeChocolateContainer.getBigBarsUsed()==-1) {makeChocolateContainer.setSmallBars(-1);
        }
        return makeChocolateContainer;
    }
}
