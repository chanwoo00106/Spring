## 양방향 연관관계 정리

아래와 같은 엔티티가 있다고 할 때 서로를 연결해 준다고 하자

```java
@Entity
class Team {
  @Id @GenerateValue
  private Long id;
  private String name;
}

@class
class Member {
  @Id @GenerateValue
  private Long id;
  private String username;
}
```

하지만 서로의 id를 가지고 연결을 해주면 패러다임의 차이로 인해 아래와 같은 모양이 나오게 되는데
이건 객체 설계가 테이블 설계를 따르게 됨으로 객체 그래프 탐색이 불가능해 지게 된다

```java
@Entity
class Team {
  @Id @GenerateValue
  private Long id;
  private String name;
  private List<Member> members = new ArrayList<>;
}

@class
class Member {
  @Id @GenerateValue
  private Long id;
  private String username;
  private Team team_id;
}
```

이러한 문제를 해결하기 위해 `OneToMany`와 `ManyToOne`, `JoinColumn` 같은 것들로 연관관계를 정의해 준다

```java
@Entity
class Team {
  @Id @GenerateValue
  private Long id;
  private String name;

  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>;
}

@class
class Member {
  @Id @GenerateValue
  private Long id;
  private String username;

  @ManyToOne
  @JoinColum(name = "team_id")
  private Team team;
}
```

## mappedBy

위 테이블에서 mappedBy라는 게 나오는 데 간단하게 설명을 하자면 연관관계의 주인을 결정하는 것이다

![mappedBy](/img/mappedBy_img.png)

객체의 연관관계의 경우 `member`에서 `team` 값을 변경해야 하는지 `team`에서 `team` 값을 바꿔야 하는 지 혼동이 오게 된다. 반대로 `team`에서 `member`값을 변경해야 하는지 `member`에서 `member`값을 변경해야 하는지 진짜 어려워 진다.

이러한 문제를 해결하기 위해 연관관계 주인을 결정해서 어디서 수정을 해줘야 하는 지를 정해 준다

그리고 연관관계의 주인은 외래키가 있는 쪽이 연관관계의 주인으로 하는 게 좋다
