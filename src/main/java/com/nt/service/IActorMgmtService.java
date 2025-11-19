package com.nt.service;

import java.util.List;

import com.nt.vo.ActorVO;

public interface IActorMgmtService {
	public List<ActorVO> showAllActorDetails();
	public String saveActor(ActorVO actorVO);
	public ActorVO showActorById(int id);
	public String editActor(ActorVO actorVO);
	public String deleteActorById(int aid);
}
