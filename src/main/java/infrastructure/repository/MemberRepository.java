package infrastructure.repository;

import domain.exception.MemberNotFoundException;
import domain.model.Member;

public interface MemberRepository {
    int nextIdentity();
    Member findById(int id) throws MemberNotFoundException;
    Member add(Member member);
}
