package com.installfuturecase.InstallFutureBackendCase.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager  userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        theUserDetailsManager
                .setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");


        theUserDetailsManager
                .setAuthoritiesByUsernameQuery("SELECT username, role FROM users WHERE username = ?");
        return theUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/user/list").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/user/add").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/user/update").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/user/delete").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/user/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("Admin")
                .build();

        UserDetails ilker = User.builder()
                .username("ilker")
                .password("{noop}ilker")
                .roles("User")
                .build();

        return new InMemoryUserDetailsManager(admin,ilker);
    }
*/
}
