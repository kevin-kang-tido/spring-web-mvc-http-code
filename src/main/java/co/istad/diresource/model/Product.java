package co.istad.diresource.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Integer id;
    private  String uuid;
    private  String name;
    private  Double price;
    private  Boolean  status;
    private LocalDateTime importDate;
    private  Integer Qty;

    @ManyToOne
    private Category category;

}
