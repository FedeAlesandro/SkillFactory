import java.util.ArrayList;
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

    public void makeClubMember(ClubMember member) throws VotesException {
        members.put(member.getId(), member);
        List <ClubMember> arrayMembers = new ArrayList<>(members.values());
        Set <ClubMember> setMembers = new HashSet<>(members.values());
        if(setMembers.size()!=arrayMembers.size()){
            members.remove(member.getId(), member);
            throw new VotesException("This member already exists.");
        }
    }
    private Boolean isAlreadyVoted (UUID idMemberVoted){
        if(alreadyVoted.get(idMemberVoted)){
            disqualifiedMembers.put(idMemberVoted, true);
            return true;
        }else{
            alreadyVoted.put(idMemberVoted, true);
            return false;
        }
    }
    // I'm not sure if it's okay to make this method because I can directly put disqualifiedMembers.get(id) in the ifclause of addvote
    private Boolean isDisqualified (UUID idMemberVoted){
        if(disqualifiedMembers.get(idMemberVoted)){
            return true;
        }else
            return false;
    }
    private void subtractVote(UUID idVoterMember){
        if(votes.containsKey(idVoterMember)){
            votes.replace(idVoterMember, votes.get(idVoterMember) - 1);
        }
    }
    private void addVote(UUID idMemberVoted, UUID idVoterMember) throws VotesException {
        if(this.isAlreadyVoted(idVoterMember)){
            throw new VotesException("The member has already voted, he will be disqualified from being voted");
        }else{
            if(isDisqualified(idMemberVoted)){
                throw new VotesException("The member you are trying to vote is not qualified to be voted because he tried to vote twice");
            }else{
                if(members.containsKey(idMemberVoted)){
                    if(votes.containsKey(idMemberVoted)){
                        votes.replace(idMemberVoted, votes.get(idMemberVoted) + 1);
                    }else
                        votes.put(idMemberVoted, 1);
                }else
                    throw new VotesException("The member you are trying to vote does not exist.");
            }
        }
    }
    public void votePresident(ClubMember member, UUID enteredId, UUID idMemberVoted) throws VotesException {
        if(!members.containsKey(member.getId())){
            throw new VotesException("You are not a member of this club!");
        }else{
            if(member.getId()!=idMemberVoted){
                this.addVote(idMemberVoted, member.getId());
                if(enteredId==null || enteredId!=member.getId()){
                    this.subtractVote(member.getId());
                    throw new VotesException("You will have one less vote because you did not enter your id.");
                }
            }else
                throw new VotesException("You can not vote yourself!");
        }
    }
    public void renounceClubMember(ClubMember member){
        members.remove(member.getId());
    }
    // Being sincere I don't know yet streams but I saw this solution on the internet and I understood it.
    public Map sortByAlphabetic(){
        Map mapSorted = members.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return mapSorted;
    }
}
