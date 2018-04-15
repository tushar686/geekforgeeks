package solutions;

import java.util.List;
import java.util.ArrayList;

public class The100Game{
    List<Integer> pool;
    int raceTo;

    The100Game(int poolMax, int finalSum){
        if(finalSum > ((poolMax*poolMax + poolMax)/2)){
            throw new IllegalArgumentException("Expected sum cannot be achieved!");
        }

        raceTo = finalSum;
        pool = new ArrayList<Integer>();

        for(int i=0;i<poolMax;i++)
            pool.add(i+1);
    }

    boolean canIWin(){
        int turns = 0;
        while(raceTo>0){
            turns++;
            System.out.println("Player"+( (turns%2==0)?"2":"1" )+" ==> "+pickANumber()+"   == Remaining ["+raceTo+"]");
        }
        return (turns%2==1);
    }

    int pickANumber(){
        int leastMax = -1;
        int len = pool.size();
        for(int i=len-1;i>=0;i--){
            int tmp = pool.get(i);
            if(tmp>=raceTo){
                pool.remove(i);
                raceTo -= tmp;
                return tmp;
            }else{
                if(leastMax > 0){
                    if(tmp < leastMax){
                        pool.remove(i);
                        raceTo -= tmp;
                        return tmp;
                    }else{
                        continue;
                    }
                }

                if(i-1 >= 0) {
                    if(tmp+pool.get(i-1) < raceTo){
                        pool.remove(i);
                        raceTo -= tmp;
                        return tmp;
                    }else{
                        leastMax = raceTo - tmp;
                        i--;
                        continue;
                    }
                }else{
                    pool.remove(i);
                    raceTo -= tmp;
                    return tmp;
                }
            }
        }

        int tmp = pool.get(pool.size()-1);
        pool.remove(pool.size()-1);
        raceTo -= tmp;
        return tmp;
    }

    public static void main(String[] args){
//        The100Game game = new The100Game(15, 100);
        The100Game game = new The100Game(5, 12);
        System.out.println("\nPlayer-"+(game.canIWin()?"1":"2")+" wins!");
    }
}
