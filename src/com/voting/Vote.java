package com.voting;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Vote {

	Candidate[] candidates;
	User[] users;

	public static Integer totalVotes = 0;

	public Vote() {

//		User user = new User();
//
//		user.setAge(28);
//		user.setCity("Sm");
//		user.setName("Viktor");
//		user.setPid("9105316060");
//		user.setSex("m");
//
//		this.users[0] = user;

	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public Candidate[] getCandidates() {
		return candidates;
	}

	public void setCandidates(Candidate[] candidates) {
		this.candidates = candidates;
	}

	public static Integer getTotalVotes() {
		return totalVotes;
	}

	public static void setTotalVotes(Integer totalVotes) {
		Vote.totalVotes = totalVotes;
	}

	public void buttonAction() {
		//TODO
	}

}
