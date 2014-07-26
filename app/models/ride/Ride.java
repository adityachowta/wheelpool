package models.ride;

import models.RideType;
import models.location.Location;
import models.user.User;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Aditya on 7/26/14.
 */
@Entity
public class Ride extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @OneToOne
    public Location source;

    @OneToOne
    public Location destination;

    @OneToOne
    public User owner;

    public RideType rideType;

    public boolean returnType;


}
