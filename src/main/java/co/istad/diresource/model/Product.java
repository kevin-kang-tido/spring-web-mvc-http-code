package co.istad.diresource.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    @Column(length = 120)
    private  String name;
    private  Double price;
    private  Boolean  status;
    private LocalDateTime importDate;
    private  Integer qty;

//    @ManyToOne
//    private Category category;
//      @PrePersist
//    public void generateUUID() {
//        this.uuid = java.util.UUID.randomUUID().toString();
//    }
}
