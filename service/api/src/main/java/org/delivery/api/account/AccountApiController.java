package org.delivery.api.account;

import lombok.RequiredArgsConstructor;
import org.delivery.api.account.model.AccountMeResponse;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.UserErrorCode;
import org.delivery.db.account.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApiController {

    /*spring은 자신과 동일한 경로에 있는 패키지에있는 빈들을 자신의 빈으로 등록을 한다.
    * 따라서 org.delivery.db에 있는것은 빈으로 등록 못한다.
    * 1. 패키지 명을 일치시킨다
    * 2. 옵션을 추가해 등록할 수 있게 만든다.    *
    *  */
    private final AccountRepository accountRepository;

    @GetMapping("/me")
    public Api<AccountMeResponse> me(){
        var response = AccountMeResponse.builder()
                .name("홍길동")
                .email("mail@gmila.com")
                .registeredAt(LocalDateTime.now())
                .build();

        return Api.OK(response);

    }

    @GetMapping("/me2")
    public Api<Object> me2(){
        var response = AccountMeResponse.builder()
                .name("홍길동")
                .email("mail@gmila.com")
                .registeredAt(LocalDateTime.now())
                .build();

//        return Api.OK(response);

        return Api.ERROR(UserErrorCode.USER_NOT_FOUND,"존재하지 않은 유저");
    }
}
