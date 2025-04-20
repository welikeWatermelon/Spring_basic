package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
// 이 놈을 아래로 바꿔줌
    private final MemberRepository memberRepository;

    // 얘가 대신 생성해주는거지
    // 즉, 맨처음 이 클래스를 생성할 때, 만들어 줄 수 있음
    // AppConfig가 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해주는 것
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
