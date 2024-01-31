package com.bankdata.securityAdmin.security;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {
    // Bean configuration for JDBC connection
    
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .url("jdbc:mysql://localhost:3306/employes_test")
          .username("bankdata")
          .password("bankdata")
          .build(); 
    }

    //Configuración para la autorización de usuario con Security
    @Bean
    public SecurityFilterChain filterChainLogin(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> configurer
                //Asignando roles de usuarios Empleado, Manager o Administrador
                .requestMatchers("/").hasRole("EMPLOYEE")
                .requestMatchers("/leaders/**").hasRole("MANAGER")
                .requestMatchers("/system/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated())
                .formLogin(form -> form
                        .loginPage("/personalLoginPage")
                        
                        //Proceso para autentificar un usuario
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll())
                        
                        //Permiso para generar un logout
                        .logout(logout -> logout
                        .permitAll()

                        //Proceso para redirigir accesos denegados
                        ).exceptionHandling(configurer -> configurer
                        .accessDeniedPage("/access-denied"));

        return http.build();
    }
}
