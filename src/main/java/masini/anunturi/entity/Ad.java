package masini.anunturi.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ad")
public class Ad {
    @Id
    private UUID id;
    @Column
    private String description;
    @Column
    private int price;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
