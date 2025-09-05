package com.example.vino_vibes.security;

import com.example.vino_vibes.security.jwt.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(@Lazy JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/admin/users/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()

                        .requestMatchers(HttpMethod.GET, "/wines").permitAll()
                        .requestMatchers(HttpMethod.GET, "/wines/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/wines/region/{region}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/wines/type/{type}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/wines/producer/{producer}").permitAll()


                        .requestMatchers(HttpMethod.POST, "/wines").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "/tasting").permitAll()
                        .requestMatchers(HttpMethod.GET, "/tasting/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/tasting/region/{region}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/tasting/type/{type}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/tasting/producer/{producer}").permitAll()


                        .requestMatchers(HttpMethod.POST, "/tasting").hasRole("USER")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
