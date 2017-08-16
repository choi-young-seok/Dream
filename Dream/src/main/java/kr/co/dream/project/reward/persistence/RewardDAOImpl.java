package kr.co.dream.project.reward.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.project.reward.domain.RewardVO;

@Repository
public class RewardDAOImpl implements RewardDAO {

	@Inject
	private SqlSession sqlsession;

	@Override
	public void rewardInfoRegister(List<RewardVO> rewards) {

		System.out.println("리워드 등록 DAO");
		for (int i = 0; i < rewards.size(); i++) {
			System.out.println(rewards.get(i).toString());
		}

		for (int i = 0; i < rewards.size(); i++) {
			sqlsession.insert("reward.rewardRegister", rewards.get(i));
		}
	}

	@Override
	public RewardVO getReward(int reward_no) {
		return sqlsession.selectOne("reward.getReward",reward_no);
	}

	@Override
	public List<RewardVO> rewardList(int project_no) {
		System.out.println("RewardDAOImpl \trewardList \t프로젝트 번호 : " + project_no);
		return sqlsession.selectList("reward.rewardList", project_no);

	}

}
