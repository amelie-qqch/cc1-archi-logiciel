package infrastructure.repository;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import domain.model.Member;

import java.io.*;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

import infrastructure.exception.FileNotCreatedException;
import infrastructure.exception.JsonRepositoryException;
import infrastructure.exception.MemberRepositoryChangesNotSavecException;

public final class JsonMemberRepository implements MemberRepository { // TODO à tester
    private final String repositoryFile = "data/members.json";
    private final Gson jsonManager;

    private List<Member> members;

    public JsonMemberRepository(Gson gson){
        jsonManager = new GsonBuilder().create();
    }


    public List<Member> extract() throws JsonIOException, JsonSyntaxException, JsonRepositoryException, FileNotFoundException {
        //Initialisation de la collection
        members = new ArrayList<>();

        File file = new File(repositoryFile);
        if(!fileExists(file)){
            try{
                createFile(file);
            } catch (IOException | FileNotCreatedException exception) {
                exception.printStackTrace();
                throw new JsonRepositoryException();
            }
        }

        JsonReader reader = new JsonReader(new FileReader(repositoryFile));
        members = this.jsonManager.fromJson(reader, Member.class); // à vérifier

        return members;
    }

    @Override
    public int nextIdentity() {
        return members.size();
    }

    @Override
    public Member findById(int id){
        for (Member member: members
        ) {
            if(member.getId() == id){
                return member;
            }
        }
        return null;
    }

    @Override
    public Member findByEmail(String email){
        for (Member member: members
        ) {
            if(member.getEmailAddress().equals(email)){
                return member;
            }
        }
        return null;
    }

    @Override
    public void add(Member member) {
        members.add(member);

    }

    @Override
    public void update(Member member) {

    }


    //Dans un service : pas de logger dans un repository
    /**
     * Met à jour le fichier des membres
     */
    private void save() throws MemberRepositoryChangesNotSavecException {
        try{
            this.jsonManager.toJson(members, new FileWriter(this.repositoryFile));
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new MemberRepositoryChangesNotSavecException();
        }

    }

    //Déplacer dans un file manager
    private boolean fileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    private void createFile(File file) throws IOException, FileNotCreatedException {
        if(!file.getParentFile().mkdirs()){
            throw new FileSystemException("Impossible de créer le(s) dossier(s) nécessaire(s).");
        }
        if(!file.createNewFile()){
            throw new FileNotCreatedException(String.format("Impossible de créer le fichier repository : %s", file.getName()));
        }
    }

}
