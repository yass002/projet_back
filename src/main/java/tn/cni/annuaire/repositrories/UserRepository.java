package tn.cni.annuaire.repositrories;

import java.util.List;

import org.springframework.data.ldap.repository.LdapRepository;

import tn.cni.annuaire.dto.User;



public interface UserRepository extends LdapRepository<User> {
 
 
}