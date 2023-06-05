package com.cys.webservice.web.domain.posts;    /*
    * Post 클래스는 실제 DB 테이블과 매칭될 클래스 == Entity 클래스
    * JPA를 사용할 때 실제 DB 쿼리에 접근하기 보다 Entity 클래스의 수정을 통해 작업한다.
    * */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본 생성자 자동 생성, 기본 생성자의 접근 권한을 protected로 변경
@Getter //클래스 내 모드 필드에 대한 getter 자동 생성.
@Entity // 테이블과 링크될 클래스임을 선언
public class Posts{
    @Id //PK
    @GeneratedValue //기본형은 자동 증가하는 정수값. 웬만하면 Long 타입의 auto increase 추천. DB로 치면 BIGINT
    private long id;

    @Column(length = 500, nullable = false) //문자열의 경우 기본 값은 VARCHAR(255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 빌더패턴 클래스 생성
             // 생성자나 static 팩토리메서드의 매개변수가 많을때 builder 패턴을 사용하면 유용하다.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}