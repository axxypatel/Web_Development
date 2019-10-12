package com.neu.web.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderSummary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderId",unique=true,nullable=false)
	private long orderId;

}
