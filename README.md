#  ✏️ 에듀테크 풀스택 3기 1조 GongCheck ✏️
```bash
프로젝트 기간 : 2023년 11월 20일 ~ 2023년 12월 8일
```
## 📚 목차 📚

1. [📂 PPT](#-PPT-)
2. [📖 프로젝트 소개](#-gongcheck-프로젝트-)
3. [🔧Development Environment](#development-environment)
4. [🔔 Prerequisite](#prerequisite)
5. [❗ How to Run in IntelliJ](#how-to-run-in-intellij)
6. [💡 기획 의도](#기획-의도)
7. [🙋‍♀️ Team_Member](#%EF%B8%8F-team_member-%EF%B8%8F)
8. [📋 개발 일지](#개발-일지)
9. [📈  요구 명세서](#-요구-명세서-)
10. [📊 Diagram](#-다이어그램-)
11. [📝 기능 설명](#-기능-설명-)
12. [📹 시연 영상](#-시연-영상-)
13. [🔨사용 기술](#-사용-기술-)


## 📂 PPT 📂

<details><summary>PPT</summary>

![1](https://github.com/seokeunpark/Team_ProJect/assets/145525099/845cda3b-d2d6-426c-ba11-d7a3a2f9950d)
![2](https://github.com/seokeunpark/Team_ProJect/assets/145525099/2ee6f5a1-9859-4fef-a5fb-0e498365e229)
![3](https://github.com/seokeunpark/Team_ProJect/assets/145525099/c9f7b63c-2069-4810-8f9d-f61b8544739b)
![4](https://github.com/seokeunpark/Team_ProJect/assets/145525099/5eea684b-c370-4732-bfb1-5d27515b1353)
![5](https://github.com/seokeunpark/Team_ProJect/assets/145525099/c35549d1-ae0a-4657-8b95-6690a15729ac)
![6](https://github.com/seokeunpark/Team_ProJect/assets/145525099/d2f005d6-8577-4d7e-913b-535129afccb0)
![7](https://github.com/seokeunpark/Team_ProJect/assets/145525099/95a1312f-0e3e-4f45-9cc1-6fd4734fe9a7)
![8](https://github.com/seokeunpark/Team_ProJect/assets/145525099/ff9a5226-d4a9-4c6e-9042-2fe169f15473)
![9](https://github.com/seokeunpark/Team_ProJect/assets/145525099/2f54dbf8-5532-45a2-9669-094c5aa03791)
![10](https://github.com/seokeunpark/Team_ProJect/assets/145525099/4a1d829a-4ecb-46dc-843c-6a252527f3a6)
![11](https://github.com/seokeunpark/Team_ProJect/assets/145525099/d2d47509-c56b-4b30-b3af-bbf739c56fae)
![12](https://github.com/seokeunpark/Team_ProJect/assets/145525099/5b964c21-ee3d-4025-9f57-5e6b4d142d71)
![13](https://github.com/seokeunpark/Team_ProJect/assets/145525099/bc8387d7-53c7-4273-b081-be46826333a9)
![14](https://github.com/seokeunpark/Team_ProJect/assets/145525099/8e6e3e6a-721c-4420-bc3d-8704ef80cf4c)
![15](https://github.com/seokeunpark/Team_ProJect/assets/145525099/b0b72718-1806-4210-a2b8-6d6bb6c7e3b4)
![16](https://github.com/seokeunpark/Team_ProJect/assets/145525099/e7619a9e-e3f7-4977-88a2-bbd2f743fd9a)
![17](https://github.com/seokeunpark/Team_ProJect/assets/145525099/e3152df5-8fe9-4e72-baac-a21094af98e5)
![18](https://github.com/seokeunpark/Team_ProJect/assets/145525099/eb8a9ed7-7925-42e5-88e4-a970b235e99a)
![19](https://github.com/seokeunpark/Team_ProJect/assets/145525099/a21401af-dbfc-44f5-8296-05b36c27a7b9)
![20](https://github.com/seokeunpark/Team_ProJect/assets/145525099/766bbe6d-20d0-480a-afb9-bce89eedd60c)
![21](https://github.com/seokeunpark/Team_ProJect/assets/145525099/77da97df-ed07-4bbf-be94-7f0fa571024d)
![22](https://github.com/seokeunpark/Team_ProJect/assets/145525099/056f6a50-0cf2-44c1-a65f-42cb63f11be7)
![23](https://github.com/seokeunpark/Team_ProJect/assets/145525099/1f8579ac-6bac-42ba-aeb4-ef3b619711c4)
![24](https://github.com/seokeunpark/Team_ProJect/assets/145525099/bcabadc2-ff26-46a4-8f28-b7152b8e1897)


</details>
      
## 📖 GongCheck 프로젝트 📖
```bash프로젝트 소개
공부인증 기능을 JSP와 MyBatis로 구현한 웹 페이지
```
## 🔧Development Environment🔧
```
언어 : Java(jdk 11), JSP
서버 : Apache Tomcat 9.0, AWS EC2
프레임워크 : MyBatis (3.5.11)
DBMS : MariaDB (3.2.0), Amazon RDS
IDE : IntelliJ IDEA
API, 라이브러리 : Daum Map API, JQuery, Lombok
```
## 🔔Prerequisite🔔
```
MariaDB 3306 포트로 연결 및 DDL 실행
Tomcat 8090 포트 연결
```
## ❗How to Run in IntelliJ❗
```
1. File > Project Structure > Project Settings > Modules > Dependencies >
+ > 1. Add Jars에 lombok.jar, mariadb-java-client-3.2.0.jar, mybatis-3.5.13.jar 파일을 추가한다.
2. 실행
```

## 💡기획 의도💡
```
매일매일 그 날의 공부를 인증하며 스스로는 성취감을 얻고 다른 사람들의 게시물을 통해 '착한자극제' 가 되어 동기를 부여하기 위해 개발
```

## 🙋‍♀️ Team_Member 🙋‍♀️

#### [😆 Gwon Jincheol 👉 GitHub](https://github.com/Jincheol-11)
#### [😆 SEOKEUN PARK 👉 GitHub](https://github.com/seokeunpark)
#### [😆 Jiyeon Lee 👉 GitHub](https://github.com/thegreatjy)
#### [😆 CK 👉 GitHub](https://github.com/kidchang93)
#### [😆 JIHYE 👉 GitHub](https://github.com/jyeeeh)

## 📋개발 일지📋
<details><summary>개발 일지</summary>
   
![개발일지](https://github.com/seokeunpark/Team_ProJect/assets/145525099/d637af23-b72b-4d7b-90c1-45ca18ff9103)
)
</details>




## 📈 요구 명세서 📈

<details><summary>요구 명세서</summary>

![요구사항명세서](https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/d16c3a72-8c43-4ae2-8600-5740c6c76bb0)
</details>

## 📊 Diagram 📊

<details><summary>ERD</summary>

![erd](https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/5f970df2-4f9b-4366-b751-f2b2d62d3dcd)

</details>

<details><summary>Usecase</summary>
      
![유스케이스](https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/8295bd03-9533-4ac7-ad05-ef643d66b918)

</details>

<details><summary>Class</summary>
  
<img src="https://github.com/Chunjae-GongCheck/GongCheck/assets/74610908/a08c510d-ea15-43d3-b246-70c15b37129a">

</details>

<details><summary>Sequence</summary>
    
 1. Actor : 회원 ( Writer )
  ![시퀀스 Writer](https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/712f61a2-d742-4de2-8b6a-c18e40ba891e)

  2. Actor : 회원 ( Replier )
  ![시퀀스 Replier](https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/dabf967d-b678-47f9-8b1f-ca74408374b8)


</details>

<details><summary>Block</summary>
    
<img src="#">
    
</details>


## 📝 기능 설명 📝
> 클릭시 코드로 이동합니다. 

<details><summary>메인화면
</summary>
<br/>

### [ 상단 고정 메뉴 ( Header ) ]
- home, 검색, 공지사항, 마이페이지, 게시글의 랭킹, 로그인 등을 볼 수 있는 태그
- 게시물 검색 기능
  - 제목과 내용에 따라 검색 가능
- 로그인이 되어 있지 않은 경우
  - Header에 있는 로그인 버튼을 클릭하여 로그인
- 로그인이 되어 있는 경우
  - 로그인 버튼이 본인의 닉네임을 나타내는 풀 다운 메뉴로 변환
  - 그 풀 다운 메뉴에는 본인 정보를 수정할 수 있으며, 자신이 쓴 글을 볼 수 있음.
  - 로그아웃 
- 랭킹에는 한 주마다 가장 많은 조회수, 가장 많은 좋아요수를 받은 게시물들이 나타남.

| 비회원 & 메뉴 |
| --- |
| <img width="1094" alt="image" src="https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/678dec32-f5fd-45db-91ea-b3fed6235a82"> | 

</br>

| 회원 & 풀다운 메뉴 |
| --- |
| <img width="1081" alt="image" src="https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/ca0b2ab4-51c3-4f96-8499-62ec77b9e983"> |

<br/>

| 검색창 모달 화면 |
| --- |
| <img width="1081" alt="image" src="https://github.com/Chunjae-GongCheck/GongCheck/assets/145524731/ce55ae62-8c43-4aec-9445-3c01e0419b79"> |

<br/>

| 페이지네이션 |
| --- |
| <img width="1081" alt="image" src="https://github.com/Chunjae-GongCheck/GongCheck/assets/145524731/156e5ad2-8ea2-471f-b610-ecd7a4d0a4c5"> |

<br/>

| 회원가입 |
| -- |
| <img src="https://github.com/Chunjae-GongCheck/GongCheck/assets/74610908/eff35fd6-7aa1-4345-b049-133c30ecefe2" width="1081" > |

<br/>

| 로그인 |
| -- |
| <img src="https://github.com/Chunjae-GongCheck/GongCheck/assets/74610908/30b39898-0173-4719-a3dc-f79e25ebecfd" width="1081" > |
<br/>

| 회원정보 수정 |
| -- |
| <img src="https://github.com/Chunjae-GongCheck/GongCheck/assets/74610908/9c0ae289-aee4-4bb9-b698-cb6e162d3e61" width="1081"> |

<br/>


</details>

<details><summary>게시판
</summary>
<br/>   

| 게시물 작성 |
| -- |
| <img src="https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/201d545b-3eec-4b04-b25b-f8c1a763b4c0" width="1081"> |

<br/>

| 게시물 수정 |
| -- |
| <img src="https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/f09c2b75-a423-48b5-8e49-a3c2bd60449c" width="1081"> |

<br/>

| 게시물 삭제 |
| -- |
| <img src="https://github.com/Chunjae-GongCheck/GongCheck/assets/145963704/5ece4b74-82c7-4caf-bdcd-f85e36b3f805" width="1081"> |

<br/>

</details>

<details><summary>댓글
</summary>
<br/>

| 댓글 작성 |
| -- |
| <img src="#" width="1081"> |

<br/>

| 댓글 수정 |
| -- |
| <img src="#" width="1081"> |

<br/>

| 댓글 삭제 |
| -- |
| <img src="#" width="1081"> |

<br/>

</details>


## 📹 시연 영상 📹

<details><summary>회원가입 및 로그인</summary>
   
![noLogin](#)
</details>
    
<details><summary>게시판</summary>
    
![login](#)

</details>

<details><summary>관리자</summary>
    
![admin](#)


</details>


## 🔨 사용 기술 🔨
<div>
<img src="https://img.shields.io/badge/Html5-E34F26?style=flat-square&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat-square&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/css3-1572B6?style=flat-square&logo=CSS3&logoColor=white">
<br>    
<img src="https://img.shields.io/badge/JAVA-C01818?style=flat-square&logo=coffeescript&logoColor=white" />
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white" />
<img src="https://img.shields.io/badge/MariaDB-003545?style=flat&logo=MariaDB&logoColor=white" />
<br>
<img src="https://img.shields.io/badge/IntelliJ-000000?style=flat-square&logo=intellijidea&logoColor=white" />
<img src="https://img.shields.io/badge/Slack-4A154B?style=flat-square&logo=slack&logoColor=white" />
<img src="https://img.shields.io/badge/StarUML-E25A1C?style=flat-square&logo=apachespark&logoColor=white" />
<br>
<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white" />
<img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white" />
<img src="https://img.shields.io/badge/Sourcetree-0052CC?style=flat-square&logo=Sourcetree&logoColor=blue" />
<br>

</div>


