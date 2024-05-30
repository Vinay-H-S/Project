package com.project.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminDTO {

	@Id
	private int id;

	private String userName;

	private String password;
}
