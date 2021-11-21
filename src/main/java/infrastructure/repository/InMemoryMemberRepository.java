package infrastructure.repository;

import domain.model.Member;

import java.util.Collection;
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
    public Member findById(int id){
        return data.get(id);
    }

    @Override
    public Member findByEmail(String email){

        Collection<Member> values = data.values();
        for (Member member: values
             ) {
            if(member.getEmailAddress().getEmailAddress().equals(email)){
                return member;
            }
        }
        return null;
    }

    @Override
    public Member add(Member member) {
        //Vérifier que l'utilisateur n'existe pas déjà avant de l'ajouter
        data.put(member.getId(), member);

        return member;
    }
}
