package com.showroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_register", catalog = "dbshowroom")
public class TbRegister implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_register", unique = true, nullable = false)
	private Long idRegister;

	@Column(name = "username", nullable = false, length = 30)
	private String username;

	@Column(name = "email", nullable = false, length = 30)
	private String email;

	@Column(name = "password", nullable = false, length = 20)
	private String password;

	public Long getIdRegister() {
		return idRegister;
	}

	public void setIdRegister(Long idRegister) {
		this.idRegister = idRegister;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
