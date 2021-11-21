package infrastructure.repository;

import domain.exception.MemberNotFoundException;
import domain.model.Member;

public interface MemberRepository {
    int nextIdentity();
    Member findById(int id);
    Member findByEmail(String email);
    Member add(Member member);
}
