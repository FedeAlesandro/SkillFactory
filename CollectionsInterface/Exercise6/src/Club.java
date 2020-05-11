import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Club {

    private Map <UUID, Boolean> disqualifiedMembers;
    private Map <UUID, Boolean> alreadyVoted;
    private Map <UUID, Integer> votes;
    private Map <UUID, ClubMember> members;

    public Club (){
        disqualifiedMembers = new HashMap<>();
        alreadyVoted = new HashMap<>();
        votes = new HashMap<>();
        members = new HashMap<>();
    }

    public List<String> getDisqualifiedMembers() {
        List<String>membersList = new ArrayList<>();
        for(UUID key : disqualifiedMembers.keySet())
        {
            membersList.add(members.get(key).toString() + " is disqualified."  + "\n");
        }
        return membersList;
    }
    public List<String> getAlreadyVoted() {
        List<String>membersList = new ArrayList<>();
        for(UUID key : alreadyVoted.keySet())
        {
            membersList.add(members.get(key).toString() + " has already voted."  + "\n");
        }
        return membersList;
    }
    public List<String> getVotes() {
        List<String>membersList = new ArrayList<>();
        for(UUID key : votes.keySet())
        {
            membersList.add(members.get(key).toString() + " has " + votes.get(key) + " votes."  + "\n");
        }
        return membersList;
    }

    public void makeClubMember(ClubMember member) throws ClubException {
        members.put(member.getId(), member);
        List <ClubMember> arrayMembers = new ArrayList<>(members.values());
        Set <ClubMember> setMembers = new HashSet<>(members.values());
        if(setMembers.size()!=arrayMembers.size()){
            members.remove(member.getId(), member);
            throw new ClubException("This member already exists.");
        }
    }
    private Boolean isAlreadyVoted (UUID idVoterMember){
        if(alreadyVoted.containsKey(idVoterMember)){
            disqualifiedMembers.put(idVoterMember, true);
            return true;
        }else{
            alreadyVoted.put(idVoterMember, true);
            return false;
        }
    }
    // I'm not sure if it's okay to make this method because I can directly put disqualifiedMembers.containsKey(id) in the ifclause of addvote
    private Boolean isDisqualified (UUID idMemberVoted){
        if(disqualifiedMembers.containsKey(idMemberVoted)){
            return true;
        }else
            return false;
    }
    private void subtractVote(UUID idVoterMember){
        if(votes.containsKey(idVoterMember)){
            if(votes.get(idVoterMember) == 1)
                votes.remove(idVoterMember);
            else
                votes.replace(idVoterMember, votes.get(idVoterMember) - 1);
        }
    }
    private void addVote(UUID idMemberVoted, UUID idVoterMember) throws ClubException {
        if(isDisqualified(idMemberVoted)){
            throw new ClubException("The member you are trying to vote is not qualified to be voted because he tried to vote more than once.");
        }
        else{
            if(members.containsKey(idMemberVoted)){
                if(this.isAlreadyVoted(idVoterMember)){
                    throw new ClubException("You have already voted, you will be disqualified from being voted from now on.");
                }else{
                   if(votes.containsKey(idMemberVoted))
                        votes.replace(idMemberVoted, votes.get(idMemberVoted) + 1);
                    else
                        votes.put(idMemberVoted, 1);
                }
            }else
                throw new ClubException("The member you are trying to vote does not exist.");
        }
    }
    public void votePresident(ClubMember member, UUID enteredId, UUID idMemberVoted) throws ClubException {
        if(!members.containsKey(member.getId())){
            throw new ClubException("You are not a member of this club!");
        }else{
            if(member.getId()!=idMemberVoted){
                this.addVote(idMemberVoted, member.getId());
                if(enteredId==null || enteredId!=member.getId()){
                    this.subtractVote(member.getId());
                    throw new ClubException("You will have one less vote because you did not enter your id or you enter a wrong id.");
                }
            }else
                throw new ClubException("You can not vote yourself!");
        }
    }
    public Boolean renounceClubMember(ClubMember member){
        if(members.remove(member.getId()) == null){
            return false;
        }else
            return true;
    }
    // Being sincere I don't know yet streams nor lambda but I saw this solution on the internet and I understood it.
    public List<String> sortByAlphabetic(){
        List<String>membersList = new ArrayList<>();
        for(UUID key : members.keySet())
        {
            membersList.add(members.get(key).toString() + "\n");
        }
        Collections.sort(membersList);
        return membersList;
    }
}
