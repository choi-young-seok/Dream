package kr.co.dream.member.join.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.member.join.persistence.JoinDAO;


@Service
public class JoinServiceImpl implements JoinService{

	@Inject
	private JoinDAO dao;
	
	
	
}
