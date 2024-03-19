package co.istad.diresource.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Product {
    private  String uuid;
    private Integer id;
    private  String name;
    private  Double price;
    private  Boolean  status;
    private LocalDateTime importDate;
    private  Integer Qty;

}
