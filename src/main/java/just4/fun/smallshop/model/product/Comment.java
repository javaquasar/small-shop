package just4.fun.smallshop.model.product;

import just4.fun.smallshop.model.BaseEntity;

import javax.persistence.*;

/**
 * Created by zinchenko on 24.02.15.
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
