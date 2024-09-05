package com.nimap.task.NimapTask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String p_name;
	Double p_price;
	int p_quantity;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	Category category;
}
