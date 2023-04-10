package net.project.moving.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Autowired
	private DataSource dataSource;  // 데이터베이스와 연동할때 사용하는 객체
	
	// 설정하기
	@Bean  // spring에서 관리하는 객체
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(
				"/", 
				"/user/signIn", 
				"/user/signUp",
				"/css/**",
				"/images/**",
				"/script/**"
				).permitAll() // 위에서 설정한 리소스의 접근은 인정 절차 없이 허용
		.anyRequest().authenticated()  // 위의 경로 이외는 모두 로그인을 해야 함
		.and()
		.formLogin() // form을 통해 로그인을 할수있게...
		.loginPage("/user/signIn")  
		// ^시큐리티에서 제공하는 로그인 폼 대신 직접 제작한 폼을 사용하겠다는 뜻^
		.loginProcessingUrl("/user/signIn").permitAll() // 데이터베이스에 접근하는 요청
		// ^로그인 폼의 action으로 저장, 인증처리를 하는 URL^
		.usernameParameter("id")  // 로그인 폼의 아이디 입력란 : name
		.passwordParameter("pw")  // 로그인 폼의 비밀번호 입력란 : name
		.and()
		.logout()
		.logoutSuccessUrl("/").permitAll()
		.and()
		.cors()
		.and()
		.httpBasic();
		
		// 빌드 후 객체화 시키기
		return http.build();
	}
	
	// 인증을 위한 쿼리문
	// controller(membercontroller.java)의 로그인 처리 기능을 대신하기 때문에 
	// POST방식의 로그인 처리 컨트롤러를 만들지 않는다.
	// 인증되지 않은 회원(미가입자)은 주소창에 error가 뜸
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		// 로그인 (인증)
		.usersByUsernameQuery(
				"select id username, pw password, enabled "
				+ "from users "
				+ "where id = ?"
				)
		// 권한
		.authoritiesByUsernameQuery(
				"select id username, rolename role_name "
				+ "from users "
				+ "where id = ?"
				);
	}
	
	// 단 반향 비밀번호 암호화 , 이거 치기만 하면 알아서 됨
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
