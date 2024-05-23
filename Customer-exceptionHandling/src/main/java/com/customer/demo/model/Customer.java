package com.customer.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	@Column
	@NotBlank(message = "Name cannot be blank")
	@Size(min=4, message="Name must contain 4 letters")
	private String customerName;
	@Column
	@Email(message = "Invalid email format")
	private String customerEmail;
	@Column
	@Pattern(regexp = "^{10,12}$", message = "Invalid phone number format")
	@Size(min=10,max=10, message="phone number must be 10 digits")
	private long contact; 
	
	

}
