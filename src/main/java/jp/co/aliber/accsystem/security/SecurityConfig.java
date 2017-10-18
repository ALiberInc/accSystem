package jp.co.aliber.accsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security設定クラス.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// login,register,companyは制限なし
				.antMatchers("/login", "/register/**", "/finish", "/css/**", "/fonts/**", "/imgs/**", "/js/**")
				.permitAll().
				// 他は制限なし
				anyRequest().authenticated().and()
				// ログイン処理の設定
				.formLogin()
				// ログイン処理のURL
				.loginPage("/login")
				// 認証成功時の遷移先
				.defaultSuccessUrl("/top_menu")
				// usernameのパラメタ名
				.usernameParameter("loginId")
				// passwordのパラメタ名
				.passwordParameter("password").permitAll().and()
				// ログアウト処理の設定
				.logout().permitAll();
	}

	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		@Autowired
		UserDetailsServiceImpl userDetailsService;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			// 認証するユーザーを設定する
			auth.userDetailsService(userDetailsService);
		}
	}
}
