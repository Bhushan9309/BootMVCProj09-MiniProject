package com.nt.service;

import java.util.List;

import com.nt.vo.ActorVO;

public interface IActorMgmtService {
	public List<ActorVO> showAllActorDetails();
	public String saveActor(ActorVO actorVO);
}
