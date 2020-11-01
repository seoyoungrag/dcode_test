package com.itsdcode.codingtest.yrseo.common.config;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import net.rakugakibox.util.YamlResourceBundle;

/*
어노테이션기반 환경구성을 돕는다. 이 어노테이션을 구현함으로써 클래스가 하나 이상의
@Bean 메소드를 제공하고 스프링 컨테이가 Bean정의를 생성하고 런타임시 그 Bean들이
요청들을 처리할 것을 선언하게 된다. 아래는 자바 클래서에서 어노테이션을 포함하는 방법을 보여준다.
*/
@Configuration
public class MessageConfiguration implements WebMvcConfigurer {

	@Bean // 세션에 지역설정. default는 KOREAN = 'ko'
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.KOREAN);
		return slr;
	}

	@Bean // 지역설정을 변경하는 인터셉터. 요청시 파라미터에 lang 정보를 지정하면 언어가 변경됨.
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override // 인터셉터를 시스템 레지스트리에 등록
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean // yml 파일을 참조하는 MessageSource 선언
	public MessageSource messageSource(@Value("${spring.messages.basename}") String basename,
			@Value("${spring.messages.encoding}") String encoding) {
		YamlMessageSource ms = new YamlMessageSource();
		ms.setBasename(basename);
		ms.setDefaultEncoding(encoding);
		ms.setAlwaysUseMessageFormat(true);
		ms.setUseCodeAsDefaultMessage(true);
		ms.setFallbackToSystemLocale(true);
		return ms;
	}

	// locale 정보에 따라 다른 yml 파일을 읽도록 처리
	private static class YamlMessageSource extends ResourceBundleMessageSource {
		@Override
		protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
			return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
		}
	}
}