package com.installfuturecase.InstallFutureBackendCase.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager  userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        theUserDetailsManager
                .setUsersByUsernameQuery("SELECT username, password, true as enabled FROM users WHERE username = ?");


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
                        .requestMatchers(HttpMethod.GET,"/transaction/list").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.POST,"/transaction/add").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.POST,"/transaction/update").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.POST,"/transaction/delete").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET,"/transaction/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET,"/totalspending/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
                        .anyRequest()
                        .authenticated()
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme basicAuthScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("basic");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicAuth", basicAuthScheme))
                .info(new Info().title("Case Study: Expense Tracking API")
                        .version("1.0.0")
                        .description("OpenAPI documentation for Innova Hackathon - Case Study "))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
    }



}
