package com.gck.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//** 관리자 정보를 담는 VO 클래스 입니다. **//

@Data
@AllArgsConstructor
public class AdminVO {
    private int adminIdx;       // 관리자 index
    private String adminId;     // 관리자 id
}
