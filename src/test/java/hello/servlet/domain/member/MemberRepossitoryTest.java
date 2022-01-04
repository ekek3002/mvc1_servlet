package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepossitoryTest {

    MemberRepossitory memberRepossitory = MemberRepossitory.getInstance();

    @AfterEach
    void afterEach() {
        memberRepossitory.clearStore();
    }
    
    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepossitory.save(member);
        //then
        Member findMember = memberRepossitory.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepossitory.save(member1);
        memberRepossitory.save(member2);
        //when
        List<Member> result = memberRepossitory.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
