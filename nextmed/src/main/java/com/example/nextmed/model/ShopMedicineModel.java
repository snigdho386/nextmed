package com.example.nextmed.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shopVsMedicine")
@Data               // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Default constructor
@AllArgsConstructor // Constructor with all fields
@Builder            // Builder pattern (optional)
public class ShopMedicineModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("shopId")
    @JsonManagedReference
    private ShopModel shop;

    @ManyToOne
    @MapsId("medicineId")
    @JsonManagedReference
    private MedicineInfoModel medicine;

    private Integer stock;
    private Double price;
    private Double discount;
    private LocalDateTime lastUpdated;
}
