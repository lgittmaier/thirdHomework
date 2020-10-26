package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(Double.NaN); //NaN devides 0/0 when it doesn't work
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        Weapon lowestWeaponDamage = null;
        int[] damage = new int[weapons.size()];
        for (int i = 0; i < weapons.size(); i++) {
            damage[i] = weapons.get(i).getDamage();
        }

        int lowestDamage = Arrays.stream(damage).min().getAsInt();
        for (int i = 0; i < weapons.size(); i++) {
            if (weapons.get(i).getDamage() == lowestDamage) {
                lowestWeaponDamage = weapons.get(i);
            }
        }

        return lowestWeaponDamage;
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max((x, y) -> x.getMinStrength() - y.getMinStrength()).orElse(null);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(a -> a.getDamageType() == DamageType.MISSILE).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream().max((x, y) -> x.getName().length() - y.getName().length()).orElse(null);
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(x -> x.getName()).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream().mapToInt(x -> x.getSpeed()).toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().map(x -> x.getValue()).reduce(0, (x, y) -> x + y);
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().map(x -> x.hashCode()).reduce(0, (x, y) -> x + y);
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream().map(x -> x.getValue() * 1.1);
    }
}
