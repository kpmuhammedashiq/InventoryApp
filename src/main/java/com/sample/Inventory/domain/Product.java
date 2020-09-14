package com.sample.Inventory.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @OneToMany(mappedBy = "product")
    private Set<ProductVariant> productVariants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public Product productName(String productName) {
        this.productName = productName;
        return this;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<ProductVariant> getProductVariants() {
        return productVariants;
    }

    public Product productVariants(Set<ProductVariant> productVariants) {
        this.productVariants = productVariants;
        return this;
    }

    public Product addProductVariant(ProductVariant productVariant) {
        this.productVariants.add(productVariant);
        productVariant.setProduct(this);
        return this;
    }

    public Product removeProductVariant(ProductVariant productVariant) {
        this.productVariants.remove(productVariant);
        productVariant.setProduct(null);
        return this;
    }

    public void setProductVariants(Set<ProductVariant> productVariants) {
        this.productVariants = productVariants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            "}";
    }
}
