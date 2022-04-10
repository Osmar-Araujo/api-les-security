package com.les.apiv2.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data@Entity
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtNasc;
	private String genero;
	private String cpf;
	private String tipoTel;
	private String tel;
	private String email;
	private String password;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "user_roles",
	            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	    private List<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
