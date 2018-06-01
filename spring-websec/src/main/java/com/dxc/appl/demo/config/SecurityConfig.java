package com.dxc.appl.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	    .authorizeRequests()
//	        .requestMatchers(EndpointRequest.to("status", "info"))
//	            .permitAll()
//	        .requestMatchers(EndpointRequest.toAnyEndpoint())
//	            .hasRole("ACTUATOR")
//	    	.antMatchers("/login", "/index")
//	    		.permitAll()
//	        .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//	            .permitAll()
//	    	.antMatchers("/pageOne", "/pageTwo")
//	    		.hasRole("USER")
	        .anyRequest()
	        	.authenticated()
	        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
    				public <O extends FilterSecurityInterceptor> O postProcess(	O fsi) {
    					fsi.setPublishAuthorizationSuccess(true);
    					return fsi;
    				}
    			})
	        .and()
	        .formLogin()
	        	.permitAll();
//	            .hasRole("USER");
//	    .and()
	   // additional configuration
	}

//    @Override
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager
//        	.createUser(User.withUsername("user").password("password")
//            .roles("USER").build());
//        return manager;
//    }

//	@Override
//	public UserDetailsService userDetailsServiceBean() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager
//        	.createUser(User.withUsername("user").password("password")
//            .roles("USER").build());
//        return manager;
//	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder(); // this is OK for getting started!
		auth
			.inMemoryAuthentication()
//			.passwordEncoder()
				.withUser(users.username("user").password("password").roles("USER"))
				.withUser(users.username("admin").password("password").roles("USER","ADMIN"));
//				.withUser("user").password("password").roles("USER");
	}
}
