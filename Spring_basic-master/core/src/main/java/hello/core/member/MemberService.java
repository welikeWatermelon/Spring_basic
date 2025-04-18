package hello.core.member;
// 회원 관리 기능

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
