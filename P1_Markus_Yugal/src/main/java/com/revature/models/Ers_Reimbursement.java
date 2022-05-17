package com.revature.models;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Ers_Reimbursement")
public class Ers_Reimbursement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id")
	private int reimb_id;
	
	@Column(name="reimb_amount")
	private double reimb_amount;
	
	@Column (name= "reimb_submitted")
	private Timestamp reimb_submitted;
	
	@Column (name= "reimb_resolved")
	private Timestamp reimb_resolved;
	
	@Column(name="reimb_description")
	private String reimb_description;
	
	@Column(name="reimb_receipt")
	private String reimb_receipt;
	
	@Column(name="reimb_author")
	private int reimb_author;
	
	@Column(name="reimb_resolver")
	private int reimb_resolver;
	
	@Column(name="reimb_statusid")
	private int reimb_statusid;
	
	@Column(name="reimb_type_id")
	private int reimb_type_id;
	
	@ManyToOne
	@JoinColumn(name="store_user_role_id", referencedColumnName = "store_userRole_id")
	private UserRole role;
	
}
