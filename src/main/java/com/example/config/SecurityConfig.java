package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/webjars/**")
                .requestMatchers("/css/**")
                .requestMatchers("/js/**")
                .requestMatchers("/h2-console/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/user/signup").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin( form -> form
                    .loginProcessingUrl("/login") // Login process path
                    .loginPage("/login") // Specify login page
                    .failureUrl("/login?error") // Transition destination when login fails
                    .usernameParameter("userId") // Login page user ID
                    .passwordParameter("password") // Login page password
                    .defaultSuccessUrl("/user/list", true) // Transition destination after success
                )
                .csrf(AbstractHttpConfigurer::disable); // Disable CSRF

        return http.build();
    }
}
