package platform.gateway.entity;

import platform.gateway.entity.enumeration.ItemType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 */
@Entity
@Table(name = "items")
@SuppressWarnings("unused")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Column
    private String itemName;

    @Column
    private ItemType itemType;

    @Column
    private String itemPrice;

    @Column
    private String creator;

    @Column
    private Date createdDate;

    @Column
    private Date updatedDate;

    @Column
    private Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemType=" + itemType +
                ", itemPrice='" + itemPrice + '\'' +
                ", creator='" + creator + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", deleted=" + deleted +
                '}';
    }
}
