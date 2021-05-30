package tn.cni.annuaire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Value("${ldap.urls}")
//	private String ldapUrls;
//
//	@Value("${ldap.base.dn}")
//	private String ldapBaseDn;
//
//	@Value("${ldap.username}")
//	private String ldapSecurityPrincipal;
//
//	@Value("${ldap.password}")
//	private String ldapPrincipalPassword;
//
//	@Value("${ldap.user.dn.pattern}")
//	private String ldapUserDnPattern;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login", "/user/**").permitAll();

		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=admin").contextSource()
				.url("ldap://localhost:10389/dc=example,dc=com").and().passwordCompare()
				.passwordEncoder(passwordEncoder()).passwordAttribute("userPassword");
//        .managerDn(ldapSecurityPrincipal)
//        .managerPassword(ldapPrincipalPassword);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	
		return new LdapShaPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
