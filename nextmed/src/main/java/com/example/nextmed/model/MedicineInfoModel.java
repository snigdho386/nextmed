package com.example.nextmed.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "medicineInfo")
@Data               // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Default constructor
@AllArgsConstructor // Constructor with all fields
@Builder            // Builder pattern (optional)
class MedicineInfoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String composition;
    private String description;
    private Long mrp;

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ShopMedicineModel> shopMedicines = new ArrayList<>();
}
