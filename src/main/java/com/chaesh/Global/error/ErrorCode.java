package com.chaesh.Global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Member
    MEMBER_NOT_FOUND(400, "M001", "존재 하지 않는 유저입니다."),
    USERNAME_ALREADY_EXIST(400, "M002", "이미 존재하는 사용자 이름입니다."),
    ACCOUNT_MISMATCH(401, "M005", "계정 정보가 일치하지 않습니다."),

    //DailyPlan
    DAILYPLAN_ALREADY_EXIST(400, "D001", "이미 데일리 플랜을 작성하였습니다. PUT으로 update 해주세요"),
    DAILYPLAN_NOT_FOUND(400, "D002", "존재 하지 않는 데일리 플랜입니다"),
    DAILYPLAN_MONTHLIST_NOT_FOUND(400, "D003", "해당 월에 작성된 데일리 플랜이 없습니다"),
    DAILYPLAN_NOT_HAVE_TODOLIST(400, "D004", "해당 데일리 플랜에 작성된 투두리스트가 없습니다"),

    //ToDoList
    TODOLIST_NOT_FOUND(400, "T001", "존재 하지 않는 투두리스트입니다"),


    //Follow
    PUSH_NOTIFICATION_FAIL(400,"F001", "푸쉬 알림이 전송되지 않았습니다."),
    FOLLOW_ALREADY_EXIST(400, "F001", "이미 팔로우한 유저입니다."),
    UNFOLLOW_FAIL(400, "F002", "팔로우하지 않은 유저와 언팔로우를 할 수 없습니다."),
    FOLLOW_MYSELF_FAIL(400, "F003", "자기 자신을 팔로우 할 수 없습니다."),
    UNFOLLOW_MYSELF_FAIL(400, "F004", "자기 자신을 언팔로우 할 수 없습니다."),
    FOLLOWER_DELETE_FAIL(400, "F005", "팔로워 삭제할 수 없는 대상입니다."),
    FOLLOWING_NOT_FOUND(400, "F006", "팔로잉한 유저가 없습니다."),
    FOLLOWER_NOT_FOUND(400, "F007", "팔로워가 없습니다."),

    ;

    private final int status;
    private final String code;
    private final String message;
}