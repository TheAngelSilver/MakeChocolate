package make.chocolate;

/**
 * Created by Corey Shaw on 6/3/2016.
 */
public class MakeChocolateContainer {
    int bigBarsUsed;
    int smallBarsUsed;
    int goalBarsUsed;
    int totalBarsUsed;
    boolean solution;

    public void setNoSolution(){
        this.bigBarsUsed = -1;
        this.smallBarsUsed = -1;
        }

    public int getBigBarsUsed() {
        return bigBarsUsed;
    }
    public void setBigBarsUsed(int bigBarsUsed) {
        this.bigBarsUsed = bigBarsUsed;
    }
    public int getSmallBarsUsed() {
        return smallBarsUsed;
    }
    public void setSmallBars(int smallBarsUsed) {
        this.smallBarsUsed = smallBarsUsed;
    }

    public MakeChocolateContainer() {
    }
    public MakeChocolateContainer(int smallBarsUsed,int bigBarsUsed) {
        this.bigBarsUsed = bigBarsUsed;
        this.smallBarsUsed = smallBarsUsed;
        //this.goalBarsUsed = goalBarsUsed;
   //     this.totalBarsUsed= totalBarsUsed;
    }
}
