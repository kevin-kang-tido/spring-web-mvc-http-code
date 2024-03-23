package co.istad.diresource.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


// pojo class
@Getter
@Setter
@NoArgsConstructor
// pojo class
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // use to auto increase of id
    private  Integer id;

    @Column(unique = true,nullable = false,length = 260)

    private String name;

    @Column(columnDefinition = "TEXT")

    private String description;



}
