package com.meibaolian.dao.other.imple;

import java.util.Date;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.other.IUserProposalDao;
import com.meibaolian.entity.UserProposal;
import com.meibaolian.util.tablehash.TableRules;

public class UserProposalDao extends BaseDao<UserProposal> implements IUserProposalDao {

	@Override
	public int  addProposal(UserProposal proposal) {
		String sql="insert into user_proposal(content,userid,addtime) values(?,?,?)";
		return super.add(sql, new Object[]{proposal.getContent(),proposal.getUserId(),new Date()}, TableRules.getUserProposalRule());
	}

	
}
