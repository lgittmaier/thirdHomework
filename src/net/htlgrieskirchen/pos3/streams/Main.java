package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void Main(String[] args){

    }

    public void readCSV() throws IOException {
            List<Weapon> list = new ArrayList<>();
            list = Files.lines(new File("weapons.csv").toPath())
                    .skip(1)
                    .map(s -> s.split("; "))
                    .map(s -> new Weapon(
                            s[0],
                            CombatType.valueOf(s[1]),
                            DamageType.valueOf(s[2]),
                            Integer.parseInt(s[3]),
                            Integer.parseInt(s[4]),
                            Integer.parseInt(s[5]),
                            Integer.parseInt(s[6])
                    ))
                    .collect(Collectors.toList());
    }

    public void damageComparator(List<Weapon> list){
        list.sort((x,y) -> {
            return Integer.compare(x.getDamage(), y.getDamage());
        });
    }

    //Bsp 2
    public void randomInt(){
        int min = 0;
        int max = 100;
        int[] list = new int[10000];
        for(int i = 0; i < list.length; i++){
            list[i] = (int) (Math.random()*100);
        }
    }

    public void randomStringArray(){
        //TODO
    }

    //BSP_3

    public final IntPredicate isEven = i -> i% 2 ==0;
    public final IntPredicate isPositive = i -> i > 0;
    public final Predicate<String> isNull = Objects::isNull;

    public final Predicate<String> isShortWord = i -> i.length() <= 4;

    public final IntPredicate isPositive_Even = isEven.and(isPositive);
    public final IntPredicate isPositive_Odd = isPositive.and(isEven.negate());

    //BSP_4
    final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(i -> i%2 == 0).map(i -> (int) Math.pow(i, 2)).reduce(0, (x,y) -> x+y);

}
