package com.api.pharmaPOS.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Authority")

public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuthorityId")
	private int authorityId;

	@Column(name = "Name")
	@Enumerated(EnumType.STRING)
	private AuthorityName name;

	@JsonIgnore
	@ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
	private List<User> users;

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public AuthorityName getName() {
		return name;
	}

	public void setName(AuthorityName name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}