package Refactor.Ship;

import Refactor.Ship.Types.CargoShip;
import Refactor.Ship.Types.DestroyerShip;
import Refactor.Ship.Types.FighterShip;
import Refactor.Ship.Types.SpaceStationShip;

public class ShipCreator {
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

    }

    private static DestroyerShip creatorDestroyer(){

    }

    private static CargoShip creatorCargo(){

    }

    private static SpaceStationShip creatorSpaceStation(){

    }
}
