package org.delivery.db.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
//오타 방지
public enum UserStatus {

    REGISTERED("등록"),
    UNREGISTERED("해지");


    private final String description;
}
