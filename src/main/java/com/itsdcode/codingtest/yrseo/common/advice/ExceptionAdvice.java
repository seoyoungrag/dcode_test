package com.itsdcode.codingtest.yrseo.common.advice;

import com.itsdcode.codingtest.yrseo.common.response.CommonResult;
import com.itsdcode.codingtest.yrseo.common.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
/*
이 어노테이션은 초기화 되지않은 final 필드나,
@NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용되곤 합니다.
*/
@RequiredArgsConstructor

/*
ControllerAdvice의 annotation은 @ControllerAdvice @RestControllerAdvice 두가지가 있습니다. 예외 발생 시 json형태로 결과를 반환하려면
@RestControllerAdvice를 클래스에 선언하면 됩니다. annotation에 추가로 패키지를 적용하면 위에서 설명한 것처럼 특정 패키지 하위의 Controller에만 로직이 적용되게도 할 수 있습니다.
ex) @RestControllerAdvice(basePackages = “com.rest.api”)
아무것도 적용하지 않으면 프로젝트의 모든 Controller에 로직이 적용됩니다.
*/
@RestControllerAdvice
public class ExceptionAdvice {

	private final ResponseService responseService;

	private final MessageSource messageSource;

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResult defaultException(HttpServletRequest request, Exception e) {
		// 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
		return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")), getMessage("unKnown.msg"));
	}

	// code정보에 해당하는 메시지를 조회합니다.
	private String getMessage(String code) {
		return getMessage(code, null);
	}

	// code정보, 추가 argument로 현재 locale에 맞는 메시지를 조회합니다.
	private String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}
}
