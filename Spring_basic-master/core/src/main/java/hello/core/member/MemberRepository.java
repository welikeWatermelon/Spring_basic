package hello.core.member;
// 저장소 인터페이스

public interface MemberRepository {

    void save(Member member);

    Member findByID(Long memberId);
}
