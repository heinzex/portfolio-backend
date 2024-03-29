package security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
          
          private final UserDetailsService userDetailsService;
          private final JwtAuthorizationFilter jwtAuthorizationFilter;
          
          @Bean
          @Primary
          SecurityFilterChain FilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
                    JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
                    jwtAuthenticationFilter.setAuthenticationManager(authManager);
                    jwtAuthenticationFilter.setFilterProcessesUrl("/api/auth");
                    
                    return http
                            .csrf().disable()
                            .authorizeRequests()
                            .anyRequest()
                            .authenticated()
                            .and()
                            .sessionManagement()
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                            .and()
                            .cors()
                            .and()
                            .addFilter(jwtAuthenticationFilter)
                            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                            .build();
          }
          
          @Bean
          AuthenticationManager authManager(HttpSecurity http) throws Exception {
                    return http.getSharedObject(AuthenticationManagerBuilder.class)
                            .userDetailsService(userDetailsService)
                            .passwordEncoder(passwordEncoder())
                            .and()
                            .build();
          }
          
          @Bean
          CorsConfigurationSource corsConfigurationSource() {
                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
                    config.addAllowedMethod("*");
                    source.registerCorsConfiguration("/**", config);
                    return source;
          }
          
          @Bean
          PasswordEncoder passwordEncoder() {
                    return new BCryptPasswordEncoder();
          }
}
