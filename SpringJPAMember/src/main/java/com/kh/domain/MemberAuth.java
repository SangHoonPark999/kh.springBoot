package com.kh.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator( 
name="MEMBER_AUTH_SEQ_GEN", 
sequenceName="MEMBER_AUTH_SEQ", 
initialValue=1, 
allocationSize=1 
)
public class MemberAuth {
	@Id
	@GeneratedValue
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no")
	private int no;
	private String auth;
	
}
