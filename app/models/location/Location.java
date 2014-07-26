package models.location;

import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Aditya on 7/26/14.
 */
@Entity
public class Location extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Constraints.Required
    public String city;

    @Constraints.Required
    public String area;

    @Constraints.Required
    public String latitude;

    @Constraints.Required
    public String longitude;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public Location() {
    }

    public Location(String city, String area, String latitude, String longitude) {
        this.city = city;
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
