package weather.dataBase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Locations")
public class Locations {

    public static class LocationBuilder {
        private int ID;

    }
}
