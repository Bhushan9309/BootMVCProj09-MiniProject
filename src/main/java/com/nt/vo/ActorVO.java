//ActorVO.java
package com.nt.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ActorVO {
     //Data Properties
	private Integer aid;
	@NonNull
	private String aname;
	@NonNull
	private String addrs;
	@NonNull
	private String category;
	@NonNull
	private String remuneration;
	
}
