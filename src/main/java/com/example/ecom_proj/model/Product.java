package com.example.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String desc;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("category")
    private String category;

    @JsonProperty("releaseDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("quantity")
    private int quantity;
}

/*
 Default JSON Serialization
The default JSON serializer may not correctly handle some fields, especially if the fields are private or have unconventional getter/setter methods.

Solution: Explicitly annotate your fields with @JsonProperty (from com.fasterxml.jackson.annotation), which ensures proper serialization:

@JsonProperty("name")
private String name;

@JsonProperty("price")
private BigDecimal price;

// Do the same for all fields.


3. Lombok and JSON Compatibility
While Lombok generally works well, there can be edge cases where the generated getters/setters conflict with Jackson serialization.

Solution: Temporarily replace @Data with explicit @Getter and @Setter annotations to isolate the problem:

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean available;
    private int quantity;

    // Add explicit getters and setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Repeat for other fields.
}

 */