package com.gestion.commande.demo.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    public void globalConfig( AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("{noop}passer").roles("GESTIONNAIRE","CLIENT");
        auth.inMemoryAuthentication().withUser("client").password("{noop}passer").roles("CLIENT");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}passer").roles("GESTIONNAIRE");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        /* http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/inscription").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/detail/{type}/{id}").permitAll()
                .antMatchers("/gestionnaire").permitAll()
                .antMatchers("/gestionnaire/home").permitAll()



                .anyRequest()
                .authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/gestionnaire/home", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
 */   }
    





}