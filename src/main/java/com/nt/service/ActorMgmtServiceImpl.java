package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ActorEntity;
import com.nt.repository.IActorRepository;
import com.nt.vo.ActorVO;
@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
    @Autowired
    private IActorRepository actorRepo;
	  
	
	@Override
	public List<ActorVO> showAllActorDetails() {
		// use repository
		List<ActorEntity> listEntity=actorRepo.findAll();
		//convert List<ActorEntity> to List<ActorVO>
		List<ActorVO> listVO=new ArrayList<ActorVO>();
		listEntity.forEach(entity->{
			ActorVO vo= new ActorVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		return listVO;
	}


	@Override
	public String saveActor(ActorVO actorVO) {
		// convert VO to Entity
		ActorEntity entity=new ActorEntity();
		BeanUtils.copyProperties(actorVO, entity);
		entity.setCreatedBy(System.getProperty("user.name"));
		//use repository
		int idVal=actorRepo.save(entity).getAid();
		return "Actor object is saved with id Value ==> "+idVal;
	}

}
