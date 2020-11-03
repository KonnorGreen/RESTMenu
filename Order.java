package edu.tarleton.restorder;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
    private String id;
    private String item;
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", item=" + item + '}';
    }
    
}
