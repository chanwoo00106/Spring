package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
    // IDENTITY 데이터베이스가 자동으로 할당해줌, 때문에 em.persist 시점에 바로 쿼리가 날라감
    // SEQUENCE 데이터메이스한테 다음 값을 물어보기 때문에 지연 로딩이 가능함
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
