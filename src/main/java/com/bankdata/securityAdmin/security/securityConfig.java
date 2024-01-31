package com.bankdata.securityAdmin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails miss1 = User.builder().username("jhon").password("{noop}123").roles("EMPLOYEE").build();
        UserDetails miss2 = User.builder().username("maria").password("{noop}123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
        UserDetails miss3 = User.builder().username("pablo").password("{noop}123").roles("EMPLOYEE", "MANAGER").build();
        return new InMemoryUserDetailsManager(miss1,miss2,miss3);
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
