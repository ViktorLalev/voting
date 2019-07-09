package com.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.voting.Candidate;

public class CandidateQuery extends DBConnection implements Serializable {

	public List<Candidate> listCandidate() {
		List<Candidate> list = new ArrayList<Candidate>();

		try {
			ps = connect().prepareStatement("SELECT * FROM candidates");

			rs = ps.executeQuery();

			while (rs.next()) {
				Candidate candidate = new Candidate();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				candidate.setPlatform(rs.getString("platform"));
				list.add(candidate);
			}
		} catch (Exception e) {

		}
		return list;

	}

	public String getById(Integer id) {
		String name = "";
		try {
			ps = connect().prepareStatement("SELECT * FROM candidates Where id = " + id);

			rs = ps.executeQuery();

			while (rs.next()) {
				name = rs.getString("name");

			}
		} catch (Exception e) {

		}
		return name;

	}

	public boolean deleteCandidate(Integer candidateId) {

		try {
			ps = connect().prepareStatement("DELETE FROM candidates WHERE id =" + candidateId);

			return ps.execute();

		} catch (Exception e) {
			System.out.println("" + e.toString());

		}
		return false;

	}

	public boolean store(String name, String platform) {

		try {

			ps = connect().prepareStatement(
					"Insert into candidates (name,platform) VALUES ('" + name + "','" + platform + "')");

			return ps.execute();

		} catch (Exception e) {
			System.out.println("" + e.toString());

		}
		return false;

	}

}
