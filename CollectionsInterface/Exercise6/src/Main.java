import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        ClubMember cm1 = new ClubMember("Federico", "111", 20);
        ClubMember cm2 = new ClubMember("Pedro", "222", 41);
        ClubMember cm3 = new ClubMember("Ernesto", "333", 29);
        ClubMember cm4 = new ClubMember("Maria", "444", 25);
        ClubMember cm5 = new ClubMember("Ernesto", "333", 29);
        ClubMember cm6 = new ClubMember("Lucas", "555", 60);

        Club club = new Club();

        // MAKING CLUB MEMBERS
        try {
            club.makeClubMember(cm1);
        } catch (ClubException e) {
            System.out.println(e);
        }
        try {
            club.makeClubMember(cm2);
        } catch (ClubException e) {
            System.out.println(e);
        }
        try {
            club.makeClubMember(cm3);
        } catch (ClubException e) {
            System.out.println(e);
        }
        try {
            club.makeClubMember(cm4);
        } catch (ClubException e) {
            System.out.println(e);
        }
        try {
            club.makeClubMember(cm6);
        } catch (ClubException e) {
            System.out.println(e);
        }

        System.out.println();
        //"This member already exists." EXCEPTION
        try {
            club.makeClubMember(cm5);
        } catch (ClubException e) {
            System.out.println(e);
        }

        //RENOUNCE OF A MEMBER
        if(club.renounceClubMember(cm3)) // if(club.renounceClubMember(cm5)) enters to else clause
            System.out.println(cm3 + " has renounce.");
        else
            System.out.println("This person is not a member of this club.");
        System.out.println();

        //ADDING A MEMBER THAT WAS REPEATED BEFORE cm3 RENOUNCE
        try {
            club.makeClubMember(cm5);
        } catch (ClubException e) {
            System.out.println(e);
        }

        //VOTING A PRESIDENT
        try {
            club.votePresident(cm1, cm1.getId(), cm4.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        try {
            club.votePresident(cm2, cm2.getId(), cm5.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        try {
            club.votePresident(cm4, cm4.getId(), cm2.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }

        // "You are not a member of this club!" EXCEPTION
        try {
            club.votePresident(cm3, cm3.getId(), cm1.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        System.out.println();

        // "You can not vote yourself!" EXCEPTION
        try {
            club.votePresident(cm1, cm1.getId(), cm1.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        System.out.println();

        // "You will have one less vote because you did not enter your id or you enter a wrong id." EXCEPTION
        try {
            club.votePresident(cm5, cm1.getId(), cm2.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        System.out.println();

        // "You have already voted, you will be disqualified from being voted from now on."
        try {
            club.votePresident(cm4, cm4.getId(), cm1.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        System.out.println();

        // "The member you are trying to vote is not qualified to be voted because he tried to vote more than once." EXCEPTION
        try {
            club.votePresident(cm6, cm6.getId(), cm4.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        System.out.println();

        // "The member you are trying to vote does not exist." EXCEPTION
        try {
            club.votePresident(cm6, cm6.getId(), cm3.getId());
        } catch (ClubException e) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Members that already voted: " + "\n" + club.getAlreadyVoted());
        System.out.println();

        System.out.println("Members that are disqualified from being voted: " + "\n" +  club.getDisqualifiedMembers());
        System.out.println();

        System.out.println("Members with votes: " + "\n" + club.getVotes());
        System.out.println();

        System.out.println("Members: " + "\n" +  club.sortByAlphabetic());
        System.out.println();

        System.out.println("Members with the amount of votes: " + "\n" + club.getAmountVotes());
    }
}
