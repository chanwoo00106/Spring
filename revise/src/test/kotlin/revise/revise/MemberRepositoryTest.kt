package revise.revise

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional()
class MemberRepositoryTest(
    @Autowired
    val memberRepository: MemberRepository
) {
    @Test
    fun testMember() {
        val member: Member = Member("hi")
        val memberId: Long = memberRepository.save(member)

        val findMember: Member = memberRepository.find(memberId)

        Assertions.assertThat(findMember.id).isEqualTo(member.id)
        Assertions.assertThat(findMember.username).isEqualTo(member.username)
        Assertions.assertThat(findMember).isEqualTo(member);
    }

    @Test
    @Rollback(false)
    fun saveTest() {
        val member: Member = Member("hi")
        val memberId: Long = memberRepository.save(member)
        val member2: Member = Member("최형우")
        val member2Id: Long = memberRepository.save(member2)
    }
}