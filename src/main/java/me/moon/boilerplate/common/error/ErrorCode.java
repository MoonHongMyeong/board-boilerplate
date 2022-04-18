package me.moon.boilerplate.common.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    //COMMON
    INVALID_INPUT_VALUE("C000", "잘못된 입력 값입니다.", 400),
    UNAUTHENTICATED("C001", "권한이 필요한 접근입니다." , 401),
    ACCESS_DENIED("C003", "잘못된 접근입니다.", 403),
    ENTITY_NOT_FOUND("C004", "엔티티를 찾을 수 없습니다.", 404),
    METHOD_NOT_ALLOWED("C005", "사용할 수 없는 요청입니다.", 405),
    INTERNAL_SERVER_ERROR("C500", "내부 서버 오류 \n관리자에게 연락해 주세요.", 500),
    //ACCOUNT
    ACCOUNT_NOT_FOUND("A001", "해당 회원을 찾을 수 없습니다.", 404),
    EMAIL_DUPLICATION("A002", "중복 된 이메일입니다.", 409),
    PASSWORD_FAILED_EXCEEDED("A003", "비밀번호 실패 횟수를 초과했습니다.", 403),
    //LOGIN
    UNAUTHORIZED_ACCESS("L001", "승인되지 않은 사용자입니다.", 401);
    private final String code;
    private final String message;
    private final int status;

    ErrorCode(String code, String message, int status){
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
