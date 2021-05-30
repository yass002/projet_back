package tn.cni.annuaire.services;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.dto.User;
import tn.cni.annuaire.repositrories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LdapTemplate ldapTemplate;

	public void save(User user) {
		//Name dn = LdapNameBuilder.newInstance(user.getId()).build();
		Name dn =  LdapNameBuilder.newInstance().add("uid", user.getUsername()).build();
		user.setId(dn);
		ldapTemplate.create(user);
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		for(User user: userRepository.findAll()) {
			list.add(user);
		}
		return  list;
	}
}
