package platform.gateway.entity;

import platform.gateway.entity.enumeration.ItemStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户商品
 */
@Entity
@Table(name = "user_items")
@SuppressWarnings("unused")
public class UserItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private Date purchasedDate;

    @Column
    private Date expiryDate;

    @Column
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;


    @Column
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserItem{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", purchasedDate=" + purchasedDate +
                ", expiryDate=" + expiryDate +
                ", itemStatus=" + itemStatus +
                ", deleted=" + deleted +
                '}';
    }
}
