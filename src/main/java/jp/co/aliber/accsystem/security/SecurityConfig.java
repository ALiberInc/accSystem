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
				// login,registerは制限なし
				.antMatchers("/login", "/register", "/css/**", "/fonts/**", "/imgs/**", "/js/**").permitAll().
				// 他は制限なし
				anyRequest().authenticated().and()
				// ログイン処理の設定
				.formLogin()
				// ログイン処理のURL
				.loginPage("/login")
				.defaultSuccessUrl("/top_menu")     // 認証成功時の遷移先
				// usernameのパラメタ名
				.usernameParameter("username")
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

	// @Override
	// protected void configure(AuthenticationManagerBuilder
	// authenticationManagerBuilder) throws Exception {
	// authenticationManagerBuilder.userDetailsService(this.userDetailsService);
	// }
	//
	// @Autowired
	// public void setUserDetailsService(UserDetailsService userDetailsService)
	// {
	// this.userDetailsService = userDetailsService;
	// }

	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	//
	// auth.userDetailsService(loginId -> {
	// TLoginUser tLoginUser = tLoginUserService.getTLoginUser(loginId);
	// System.out.println(loginId);
	// return new User(tLoginUser.getLoginId(), tLoginUser.getPassword(), true,
	// true, true, true,
	// AuthorityUtils.createAuthorityList("USER"));
	// });
	//
	// }
}
