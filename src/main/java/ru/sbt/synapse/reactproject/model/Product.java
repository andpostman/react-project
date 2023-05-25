package ru.sbt.synapse.reactproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products", schema = "react_market")
@Getter
@Immutable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "img")
    private String img;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (!getTitle().equals(product.getTitle())) return false;
        if (!this.getImg().equals(product.getImg())) return false;
        if (!getDescription().equals(product.getDescription())) return false;
        return getCategory().equals(product.getCategory());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + this.getImg().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getCategory().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("productId", id)
                .append("title", title)
                .append("image", img)
                .append("description", description)
                .append("category", category)
                .append("price",price)
                .toString();
    }
}
