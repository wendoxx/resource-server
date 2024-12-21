package org.example.oauth2resourceserverproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@Data
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "sold-by")
    private String soldBy;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @ToString.Exclude
    @JsonBackReference
    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();
}