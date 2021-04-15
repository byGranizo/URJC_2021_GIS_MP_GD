package Ship;

import Ship.Types.CargoShip;
import Ship.Types.DestroyerShip;
import Ship.Types.FighterShip;
import Ship.Types.SpaceStationShip;
import Ship.Addons.*;

import java.io.Serializable;
import java.util.Scanner;

public class ShipCreator implements Serializable {
    public static Ship createShip(ShipType type){
        Ship ship = null;
        switch (type){
            case FIGHTER:
                ship = creatorFighter();
                break;
            case DESTROYER:
                ship = creatorDestroyer();
                break;
            case CARGO:
                ship = creatorCargo();
                break;
            case SPACE_STATION:
                ship = creatorSpaceStation();
                break;
        }

        return ship;
    }

    private static FighterShip creatorFighter(){
        Scanner scan = new Scanner(System.in);
        int totalPower = 0;

        System.out.println("Register number:");
        String registerNum = scan.nextLine();

        Engine[] engines = createEngineArray();

        Weapon[] weapons = createWeaponArray("2");

        Defense defense = createDefense();

        for (Weapon weapon : weapons ) {
            totalPower = totalPower + weapon.getPower();
        }

        return new FighterShip(registerNum, engines,totalPower,defense.getAbsorption(),weapons, defense);
    }

    private static DestroyerShip creatorDestroyer(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Register number:");
        String registerNum = scan.nextLine();

        System.out.println("Crew size:");
        int crewSize = scan.nextInt();

        Engine[] engines = createEngineArray();

        Weapon[] weapons = createWeaponArray("infinite");

        Defense[] defense = createDefenseArray("2");
        int totalPower = 0;
        int totalDefense = 0;

        for (Weapon weapon : weapons ) {
            totalPower = totalPower + weapon.getPower();
        }

        for (Defense defe : defense ) {
            totalDefense = totalDefense + defe.getAbsorption();
        }
        return new DestroyerShip(registerNum, engines, crewSize,totalPower,totalDefense, weapons, defense);
    }

    private static CargoShip creatorCargo(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Register number:");
        String registerNum = scan.nextLine();

        System.out.println("Crew size:");
        int crewSize = scan.nextInt();

        System.out.println("Cargo capacity:");
        int maxWeight = scan.nextInt();

        Engine[] engines = createEngineArray();

        Defense defense = createDefense();

        return new CargoShip(registerNum, engines, crewSize,0,defense.getAbsorption() ,maxWeight, defense);
    }

    private static SpaceStationShip creatorSpaceStation(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Register number:");
        String registerNum = scan.nextLine();

        System.out.println("Crew size:");
        int crewSize = scan.nextInt();

        System.out.println("Maximum passengers:");
        int maxPassengers = scan.nextInt();

        Engine[] engines = createEngineArray();

        Defense[] defense = createDefenseArray("3");

        int totalDefense = 0;
        for (Defense defe : defense ) {
            totalDefense = totalDefense + defe.getAbsorption();
        }
        return new SpaceStationShip(registerNum, engines, crewSize,0,totalDefense, maxPassengers,defense);
    }


    //Engines
    private  static Engine[] createEngineArray(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Number of engines(1-2):");
        int nEngines = scan.nextInt();

        Engine[] engines = new Engine[nEngines];
        for(int i=0;i<nEngines;i++){
            engines[i] = createEngine();
        }
        return engines;
    }
    private static Engine createEngine(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter engine type");
        System.out.println("1. curvature motor");
        System.out.println("2. trace compressor");
        System.out.println("3. motor FTL");
        System.out.println("4. solar sails");
        System.out.println("5. ionic engine");

        int typeInt = scan.nextInt();
        EngineType type = null;

        switch (typeInt) {
            case 1:
                type = EngineType.CURVATURE_MOTOR;
                break;
            case 2:
                type = EngineType.TRACE_COMPRESSOR;
                break;
            case 3:
                type = EngineType.MOTOR_FTL;
                break;
            case 4:
                type = EngineType.SOLAR_SAILS;
                break;
            case 5:
                type = EngineType.IONIC_ENGINE;
                break;
        }

        System.out.println("Speed:");
        int speed = scan.nextInt();

        return new Engine(type, speed);
    }

    //Weapons
    private  static Weapon[] createWeaponArray(String max){
        Scanner scan = new Scanner(System.in);

        System.out.println("Number of weapons(1-" + max + "):");
        int nWeapons = scan.nextInt();

        Weapon[] weapons = new Weapon[nWeapons];
        for(int i=0;i<nWeapons;i++){
            weapons[i] = createWeapon();
        }
        return weapons;
    }
    private static Weapon createWeapon(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter weapon type");
        System.out.println("1. Plasma cannons");
        System.out.println("2. Thermonucelar missiles");
        System.out.println("3. Laser rays");
        System.out.println("4. PEM");

        int typeInt = scan.nextInt();
        WeaponType type = null;

        switch (typeInt) {
            case 1:
                type = WeaponType.PLASMA_CANNONS;
                break;
            case 2:
                type = WeaponType.THERMONUCLEAR_MISSILES;
                break;
            case 3:
                type = WeaponType.LASER_RAYS;
                break;
            case 4:
                type = WeaponType.PEM;
                break;
        }

        System.out.println("Power:");
        int power = scan.nextInt();

        return new Weapon(type, power);
    }

    //Defense
    private  static Defense[] createDefenseArray(String max){
        Scanner scan = new Scanner(System.in);

        System.out.println("Number of defenses(1-" + max + "):");
        int nDefenses = scan.nextInt();

        Defense[] defenses = new Defense[nDefenses];
        for(int i=0;i<nDefenses;i++){
            defenses[i] = createDefense();
        }
        return defenses;
    }
    private static Defense createDefense(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter defense type");
        System.out.println("1. Shield");
        System.out.println("2. Armor");

        int typeInt = scan.nextInt();

        Defense defense = null;
        int absorption;
        switch (typeInt) {
            case 1:
                System.out.println("Absorption:");
                absorption = scan.nextInt();

                System.out.println("Energy:");
                int energy = scan.nextInt();

                defense = new Shield(absorption, energy);
                break;
            case 2:
                System.out.println("Absorption:");
                absorption = scan.nextInt();
                scan.nextLine();
                System.out.println("Material:");
                String material = scan.nextLine();

                System.out.println("Extra weight:");
                int extraWeight = scan.nextInt();
                scan.nextLine();
                defense = new Armor(absorption, material, extraWeight);
                break;
        }

        System.out.println("Power:");
        int power = scan.nextInt();

        return defense;
    }
}
