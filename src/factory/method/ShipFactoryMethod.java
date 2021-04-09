package factory.method;

import Ships.Ship;
import models.Customers;
import ship.complements.Defense;
import ship.complements.Propulsion;
import ship.complements.Weapon;
import java.util.ArrayList;

public interface ShipFactoryMethod {

    Ship createShip (String regNum, Customers owner, Propulsion[] arrayPropellers, int crewNum,
                            Weapon[] arrayWeapons, Defense[] arrayDefenses, ArrayList<Ship> shipList);
}
