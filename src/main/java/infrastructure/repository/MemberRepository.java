package infrastructure.repository;

import domain.model.Member;

public interface MemberRepository {
    int nextIdentity();
    Member findById(int id);
    Member findByEmail(String email);
    void add(Member member);
    void update (Member member);
}
