package infrastructure.repository;

import domain.exception.MemberNotFoundException;
import domain.model.Member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryMemberRepository implements MemberRepository {
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private final Map<Integer, Member> data = new ConcurrentHashMap<>();

    @Override
    public int nextIdentity() {
        return this.idCounter.incrementAndGet();
    }

    @Override
    public Member findById(int id) throws MemberNotFoundException {
        final Member member = data.get(id);

        if(member == null){
            throw new MemberNotFoundException(String.format("Utilisateur introuvable ou inexistant %d", id) );
        }

        return member;
    }

    @Override
    public Member add(Member member) {
        data.put(member.getId(), member);

        return member;
    }
}
