package com.sunny.securityex01.model;



import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

// ORM - Object Relation(테이블) Mapping
// 자바 오브젝트를 통해서 테이블을 매핑 시켜주는 기술

@Data
@Entity
public class User {
	@Id //primary key를 걸어주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	@CreationTimestamp
	private Timestamp createDate;
}
