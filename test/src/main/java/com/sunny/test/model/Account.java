package com.sunny.test.model;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
	private int id;
	private String username;
	private String accountNumber;
	private int money;
}
