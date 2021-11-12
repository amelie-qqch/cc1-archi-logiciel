package infrastructure.repository;

import domain.exception.MemberNotFoundException;
import domain.model.Member;

public final class JsonMemberRepository implements MemberRepository {
    private final String repositoryFile = "todo";



    @Override
    public int nextIdentity() {
        //todo
        return 0;
    }

    @Override
    public Member findById(int id) throws MemberNotFoundException {
        //todo
        return null;
    }

    @Override
    public Member add(Member member) {
        //todo
        return null;
    }
}
