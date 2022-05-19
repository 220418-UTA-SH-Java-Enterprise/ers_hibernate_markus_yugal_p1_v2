package com.revature.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Ers_Reimbursement_type")
public class Ers_reimbursement_Type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_typeid")
	private int reimb_type_id;
	
	@Column(name="reimb_type", unique = true, nullable = true)
	private String reimb_type;

	public Ers_reimbursement_Type() {
		super();
	}

	public Ers_reimbursement_Type(String reimb_type) {
		super();
		this.reimb_type = reimb_type;
	}

	public Ers_reimbursement_Type(int reimb_type_id, String reimb_type) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimb_type, reimb_type_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ers_reimbursement_Type other = (Ers_reimbursement_Type) obj;
		return Objects.equals(reimb_type, other.reimb_type) && reimb_type_id == other.reimb_type_id;
	}

	@Override
	public String toString() {
		return "Ers_reimbursement_Type [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + "]";
	}
	
	
}
