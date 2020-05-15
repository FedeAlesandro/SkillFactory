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

    public List<ClubMember> getDisqualifiedMembers() {
        List<ClubMember>membersList = new ArrayList<>();
        for(UUID key : disqualifiedMembers.keySet())
        {
            membersList.add(members.get(key));
        }
        return membersList;
    }
    public List<ClubMember> getAlreadyVoted() {
        List<ClubMember>membersList = new ArrayList<>();
        for(UUID key : alreadyVoted.keySet())
        {
            membersList.add(members.get(key));
        }
        return membersList;
    }
    public List<ClubMember> getVotes() {
        List<ClubMember>membersList = new ArrayList<>();
        for(UUID key : votes.keySet())
        {
            membersList.add(members.get(key));
        }
        return membersList;
    }
    // I had to do this function because in getVotes I wasnt able to return the amount of votes using a ClubMember List
    public List<String> getAmountVotes() {
        List<String>votesMembers = new ArrayList<>();
        for(UUID key : votes.keySet())
        {
            votesMembers.add("\nID: " + key + ", name: " + members.get(key).getName() + ", number of votes: " + votes.get(key));
        }
        Collections.sort(votesMembers);
        return votesMembers;
    }
    public void makeClubMember(ClubMember member) throws ClubException {
        if(members.containsValue(member)){
            throw new ClubException("This member already exists.");
        }else
            members.put(member.getId(), member);
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
    private Boolean isDisqualified (UUID idMemberVoted){
        return disqualifiedMembers.containsKey(idMemberVoted);
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
        if(isDisqualified(idMemberVoted)) {
            throw new ClubException("The member you are trying to vote is not qualified to be voted because he tried to vote more than once.");
        }
        if(!members.containsKey(idMemberVoted)) {
            throw new ClubException("The member you are trying to vote does not exist.");
        }
        if(this.isAlreadyVoted(idVoterMember)) {
            throw new ClubException("You have already voted, you will be disqualified from being voted from now on.");
        }
        if(votes.containsKey(idMemberVoted))
            votes.replace(idMemberVoted, votes.get(idMemberVoted) + 1);
        else
            votes.put(idMemberVoted, 1);
    }
    public void votePresident(ClubMember member, UUID enteredId, UUID idMemberVoted) throws ClubException {
        if(!members.containsKey(member.getId())) {
            throw new ClubException("You are not a member of this club!");
        }
        if(member.getId()==idMemberVoted) {
            throw new ClubException("You can not vote yourself!");
        }
        if(enteredId==null || enteredId!=member.getId()){
            this.subtractVote(member.getId());
            throw new ClubException("You will have one less vote because you did not enter your id or you enter a wrong id.");
        }
        this.addVote(idMemberVoted, member.getId());
    }
    public Boolean renounceClubMember(ClubMember member){
        if(members.remove(member.getId()) == null){
            return false;
        }else
            return true;
    }
    public List<ClubMember> sortByAlphabetic(){
        List<ClubMember>membersList = new ArrayList<>();
        for(UUID key : members.keySet())
        {
            membersList.add(members.get(key));
        }
        Collections.sort(membersList);
        return membersList;
    }
}
