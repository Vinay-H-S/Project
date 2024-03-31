package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "adminservice")
@Data
@NamedQuery(name = "findAdmins",query = "select en from AdminControlEntity en")
@NamedQuery(name = "getAdminsById",query = "select en from AdminControlEntity en where id=:id")
public class AdminControlEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;

}
