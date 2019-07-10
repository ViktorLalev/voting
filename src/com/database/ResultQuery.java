package com.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.voting.Result;

public class ResultQuery extends DBConnection implements Serializable {

	public List<Result> listResults() {
		List<Result> list = new ArrayList<Result>();

		try {
			ps = connect().prepareStatement("SELECT candidate_id,count(id) as votes FROM votes group by candidate_id");

			rs = ps.executeQuery();

			while (rs.next()) {
				Result result = new Result();

				result.setCandidate_id(rs.getInt("candidate_id"));
				result.setVotes(rs.getInt("votes"));

				list.add(result);
			}
		} catch (Exception e) {

		}
		return list;

	}

}
