package kr.co.dream.user.join.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.user.join.persistence.JoinDAO;

@Service
public class JoinServiceImpl implements JoinService{

	@Inject
	private JoinDAO dao;
	
}
