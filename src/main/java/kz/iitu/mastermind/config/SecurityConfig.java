package kz.iitu.mastermind.config;

import kz.iitu.mastermind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/showSignInForm").permitAll()
                .antMatchers("/logInSuccess").permitAll()
                .antMatchers("/users/register/").permitAll()
                .antMatchers("/showSignUpForm").permitAll()
                .antMatchers("/saveSignUpForm/").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/list-users").permitAll()
                .antMatchers("/showUserInfoAddForm/").permitAll()
                .antMatchers("/user-info/add/").permitAll()
                .antMatchers("/users/find/**").hasAuthority("ADMIN")
                .antMatchers("/users/update/**").hasAuthority("ADMIN")
                .antMatchers("/users/delete/**").hasAuthority("ADMIN")
                .antMatchers("/users/games/**").permitAll()
                .antMatchers("/mastermind").permitAll()
                .antMatchers("/games/**").permitAll()
                .antMatchers("/games/get").permitAll()
                .antMatchers("/games/add/").hasAuthority("ADMIN")
                .antMatchers("/games/update/**").hasAuthority("ADMIN")
                .antMatchers("/games/delete/**").hasAuthority("ADMIN")
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**")
                .permitAll()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}

