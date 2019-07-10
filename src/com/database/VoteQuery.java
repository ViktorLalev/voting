package com.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.voting.Candidate;
import com.voting.Vote;
import com.voting.VoteSum;

public class VoteQuery extends DBConnection implements Serializable {

	public List<Vote> listVotes() {
		List<Vote> list = new ArrayList<Vote>();

		try {
			ps = connect().prepareStatement("SELECT * FROM votes");

			rs = ps.executeQuery();

			while (rs.next()) {
				Vote vote = new Vote();
				vote.setId(rs.getInt("id"));
				vote.setCandidate_id(rs.getInt("candidate_id"));
				vote.setAge(rs.getInt("age"));
				vote.setSex(rs.getString("sex"));
				vote.setCity(rs.getString("city"));
				vote.setEducation(rs.getString("education"));
				list.add(vote);
			}
		} catch (Exception e) {

		}
		return list;

	}

	public boolean store(Integer candidateId, Integer age, String sex, String city, String education) {

		try {

			ps = connect().prepareStatement("Insert into votes (candidate_id,age,sex,city,education) " + "VALUES ('"
					+ candidateId + "','" + age + "','" + sex + "','" + city + "','" + education + "')");

			return ps.execute();

		} catch (Exception e) {
			System.out.println("" + e.toString());

		}
		return false;

	}

}
