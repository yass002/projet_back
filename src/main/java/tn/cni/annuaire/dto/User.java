package tn.cni.annuaire.dto;

import javax.naming.Name;
import javax.naming.ldap.LdapName;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
@Entry( objectClasses = { "person", "inetOrgPerson","organizationalPerson", "top" })
@Data
public class User {
	@Id
	@JsonIgnore
	@JsonDeserialize(as=LdapName.class)
	private Name id;
	private @Attribute(name = "cn") String fullName;
	private @Attribute(name = "sn") String lastName;
	private @Attribute(name = "uid") String username;
	private @Attribute(name = "userPassword") String password;
}
