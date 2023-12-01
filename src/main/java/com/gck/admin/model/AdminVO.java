package com.gck.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 관리자
@Data
@AllArgsConstructor
public class AdminVO {
    private int adminIdx;       // 관리자 index
    private String adminId;     // 관리자 id
}
