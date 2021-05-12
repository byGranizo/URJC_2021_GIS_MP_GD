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
                ship.setType(ShipType.FIGHTER);
                break;
            case DESTROYER:
                ship = creatorDestroyer();
                ship.setType(ShipType.DESTROYER);
                break;
            case CARGO:
                ship = creatorCargo();
                ship.setType(ShipType.CARGO);
                break;
            case SPACE_STATION:
                ship = creatorSpaceStation();
                ship.setType(ShipType.SPACE_STATION);
                break;
        }

        return ship;
    }

    private static FighterShip creatorFighter(){
        Scanner scan = new Scanner(System.in);
        int totalPower = 0;

        System.out.println("Register number:");
        String registerNum = "";
        while(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
            System.out.println("Enter id:");
            registerNum = scan.nextLine();

            if(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
                System.out.println("Wrong input");
            }
        }

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
        String registerNum = "";
        while(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
            System.out.println("Enter id:");
            registerNum = scan.nextLine();

            if(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
                System.out.println("Wrong input");
            }
        }

        int crewSize = -1;
        while (crewSize < 0){
            System.out.println("Crew size:");
            crewSize = scan.nextInt();
            scan.nextLine();
            if(crewSize < 0){
                System.out.println("Invalid input");
            }
        }

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
        String registerNum = "";
        while(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
            System.out.println("Enter id:");
            registerNum = scan.nextLine();

            if(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
                System.out.println("Wrong input");
            }
        }



        int crewSize = -1;
        while (crewSize < 0){
            System.out.println("Crew size:");
            crewSize = scan.nextInt();
            scan.nextLine();
            if(crewSize < 0){
                System.out.println("Invalid input");
            }
        }

        int maxWeight = -1;
        while (maxWeight < 0){
            System.out.println("Cargo capacity:");
            maxWeight = scan.nextInt();
            scan.nextLine();
            if(maxWeight < 0){
                System.out.println("Invalid input");
            }
        }


        Engine[] engines = createEngineArray();

        Defense defense = createDefense();

        return new CargoShip(registerNum, engines, crewSize,0,defense.getAbsorption() ,maxWeight, defense);
    }

    private static SpaceStationShip creatorSpaceStation(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Register number:");
        String registerNum = "";
        while(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
            System.out.println("Enter id:");
            registerNum = scan.nextLine();

            if(!registerNum.matches("[A-Za-z][0-9]{4}[A-Za-z]{3}")){
                System.out.println("Wrong input");
            }
        }

        int crewSize = -1;
        while (crewSize < 0){
            System.out.println("Crew size:");
            crewSize = scan.nextInt();
            scan.nextLine();
            if(crewSize < 0){
                System.out.println("Invalid input");
            }
        }


        int maxPassengers = -1;
        while (maxPassengers < 0){
            System.out.println("Maximum passengers:");
            maxPassengers = scan.nextInt();
            scan.nextLine();
            if(maxPassengers < 0){
                System.out.println("Invalid input");
            }
        }


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

        int nEngines = 0;
        while(nEngines < 1 || nEngines > 2){
            System.out.println("Number of engines(1-2):");
            nEngines = scan.nextInt();
            scan.nextLine();

            if(nEngines < 1 || nEngines > 2){
                System.out.println("Wrong input");
            }
        }


        Engine[] engines = new Engine[nEngines];
        for(int i=0;i<nEngines;i++){
            engines[i] = createEngine();
        }
        return engines;
    }
    private static Engine createEngine(){
        Scanner scan = new Scanner(System.in);

        int typeInt = -1;
        EngineType type = null;

        while(typeInt < 1 || typeInt > 5){
            System.out.println("Enter engine type");
            System.out.println("1. curvature motor");
            System.out.println("2. trace compressor");
            System.out.println("3. motor FTL");
            System.out.println("4. solar sails");
            System.out.println("5. ionic engine");

            typeInt = scan.nextInt();
            scan.nextLine();

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
        }

        int speed = -1;
        while (speed < 0){
            System.out.println("Speed:");
            speed = scan.nextInt();
            scan.nextLine();
            if(speed < 0){
                System.out.println("Invalid input");
            }
        }


        return new Engine(type, speed);
    }

    //Weapons
    private  static Weapon[] createWeaponArray(String max){
        Scanner scan = new Scanner(System.in);

        int nWeapons = 0;
        int maxInt = max.equals("infinite") ? Integer.MAX_VALUE : Integer.parseInt(max);
        while(nWeapons < 1 || nWeapons > maxInt){
            System.out.println("Number of weapons(1-" + maxInt + "):");
            nWeapons = scan.nextInt();
            scan.nextLine();

            if(nWeapons < 1 || nWeapons > maxInt){
                System.out.println("Wrong input");
            }
        }

        Weapon[] weapons = new Weapon[nWeapons];
        for(int i=0;i<nWeapons;i++){
            weapons[i] = createWeapon();
        }
        return weapons;
    }
    private static Weapon createWeapon(){
        Scanner scan = new Scanner(System.in);

        int typeInt = -1;
        WeaponType type = null;
        while(typeInt < 1 || typeInt > 4){
            System.out.println("Enter weapon type");
            System.out.println("1. Plasma cannons");
            System.out.println("2. Thermonucelar missiles");
            System.out.println("3. Laser rays");
            System.out.println("4. PEM");

            typeInt = scan.nextInt();
            scan.nextLine();

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
        }


        int power = -1;
        while (power < 0){
            System.out.println("Power:");
            power = scan.nextInt();
            scan.nextLine();
            if(power < 0){
                System.out.println("Invalid input");
            }
        }


        return new Weapon(type, power);
    }

    //Defense
    private  static Defense[] createDefenseArray(String max){
        Scanner scan = new Scanner(System.in);

        int nDefenses = 0;
        int maxInt = max.equals("infinite") ? Integer.MAX_VALUE : Integer.parseInt(max);
        while(nDefenses < 1 || nDefenses > maxInt){
            System.out.println("Number of defenses(1-" + maxInt + "):");
            nDefenses = scan.nextInt();
            scan.nextLine();

            if(nDefenses < 1 || nDefenses > maxInt){
                System.out.println("Wrong input");
            }
        }


        Defense[] defenses = new Defense[nDefenses];
        for(int i=0;i<nDefenses;i++){
            defenses[i] = createDefense();
        }
        return defenses;
    }
    private static Defense createDefense(){
        Scanner scan = new Scanner(System.in);

        int typeInt = -1;
        Defense defense = null;
        int absorption;

        while(typeInt < 1 || typeInt > 4){
            System.out.println("Enter defense type");
            System.out.println("1. Shield");
            System.out.println("2. Armor");

            typeInt = scan.nextInt();
            scan.nextLine();

            switch (typeInt) {
                case 1:
                    System.out.println("Absorption:");
                    absorption = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Energy:");
                    int energy = scan.nextInt();
                    scan.nextLine();

                    defense = new Shield(absorption, energy);
                    break;
                case 2:
                    System.out.println("Absorption:");
                    absorption = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Material:");
                    String material = scan.nextLine();

                    int extraWeight = -1;
                    while (extraWeight < 0){
                        System.out.println("Extra weight:");
                        extraWeight = scan.nextInt();
                        scan.nextLine();
                        if(extraWeight < 0){
                            System.out.println("Invalid input");
                        }
                    }

                    defense = new Armor(absorption, material, extraWeight);
                    break;
            }
        }



        int power = -1;
        while (power < 0){
            System.out.println("Power:");
            power = scan.nextInt();
            scan.nextLine();
            if(power < 0){
                System.out.println("Invalid input");
            }
        }

        return defense;
    }
}
