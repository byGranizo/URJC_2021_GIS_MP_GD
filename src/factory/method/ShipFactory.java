package factory.method;

import Ships.*;
import models.Customers;
import ship.complements.Defense;
import ship.complements.Propulsion;
import ship.complements.Weapon;

import java.util.ArrayList;

public class ShipFactory implements ShipFactoryMethod{
    @Override
    public Ship createShip(String regNum, Customers owner, Propulsion[] arrayPropellers, int crewNum,
                           Weapon[] arrayWeapons, Defense[] arrayDefenses, ArrayList<Ship> shipList) {

        if (crewNum == 1) {
            return new Fighter(regNum, owner, arrayPropellers, crewNum, arrayWeapons, arrayDefenses);
        }

        else if (shipList != null){
            return new SpaceStation(regNum, owner, arrayPropellers, crewNum, arrayDefenses, shipList);
        }

        else if (arrayWeapons == null){
            return new CargoShip(regNum, owner, arrayPropellers, crewNum, arrayDefenses);
        }

        else {
            return new Destroyer(regNum, owner, arrayPropellers, crewNum, arrayWeapons, arrayDefenses);
        }
    }
}
