package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ActorEntity;
import com.nt.error.ActorNotFoundException;
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


	@Override
	public ActorVO showActorById(int id) {
		// Load the object
		ActorEntity actorEntity=actorRepo.findById(id).orElseThrow(()-> new ActorNotFoundException("Invalid Actor Id"));
		//convert entity object to vo Object
		ActorVO actorVO=new ActorVO();
		BeanUtils.copyProperties(actorEntity, actorVO);
		return actorVO;
	}


	@Override
	public String editActor(ActorVO actorVO) {
		//Load the object
		ActorEntity actorEntity=actorRepo.findById(actorVO.getAid()).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		//convert VO to entity
		BeanUtils.copyProperties(actorVO, actorEntity);
		actorEntity.setUpdatedBy(System.getProperty("user.name"));
		//use repository
		int idVal=actorRepo.save(actorEntity).getAid();
		return idVal+" id Actor is updated";
	}


	@Override
	public String deleteActorById(int aid) {
		//Load object
		actorRepo.findById(aid).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		//use repository
		actorRepo.deleteById(aid);
		//redirect the request
		return aid+" id actor is deleted";
	}

}
