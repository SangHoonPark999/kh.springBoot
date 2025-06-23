package com.kh.domain;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator( 
name="MEMBER_SEQ_GEN", 
sequenceName="MEMBER_SEQ", 
initialValue=1, 
allocationSize=1 
)
public class Member {
	@Id
	@GeneratedValue
	private int no;
	private String id;
	private String pw;
	private String name;
	private int coin;
	@CreationTimestamp
	@Column(name="reg_date")
	private Date regDate;
	@CreationTimestamp
	@Column(name="upd_date")
	private Date updDate;
	private String enabled;
	//1 : N 방식
	@OneToMany(mappedBy = "no")
	private List<MemberAuth> authList;
}
