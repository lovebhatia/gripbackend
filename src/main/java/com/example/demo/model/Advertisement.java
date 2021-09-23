package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Advertisement {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long adv_id;

	@Column(name = "product_link", length = 4000)
	private String product_link;

    public long getAdv_id() {
        return adv_id;
    }

    public void setAdv_id(long adv_id) {
        this.adv_id = adv_id;
    }

    public String getProduct_link() {
        return product_link;
    }

    public void setProduct_link(String product_link) {
        this.product_link = product_link;
    }
}
