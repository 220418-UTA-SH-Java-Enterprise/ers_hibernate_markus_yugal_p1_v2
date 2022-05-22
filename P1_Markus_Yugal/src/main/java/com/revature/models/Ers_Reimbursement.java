package com.revature.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

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
	private String reimb_author;
	
	@Column(name="reimb_resolver")
	private String reimb_resolver;
	
	@Column(name="reimb_statusid")
	private int reimb_statusid;
	
	@Column(name="reimb_type_id")
	private int reimb_type_id;
	
	@Column(name="reimb_type")
	private String reimb_type;

	public Ers_Reimbursement() {
		super();
	}

	public Ers_Reimbursement(double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, String reimb_receipt, String reimb_author, String reimb_resolver,
			int reimb_statusid, int reimb_type_id, String reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_statusid = reimb_statusid;
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
	}

	public Ers_Reimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, String reimb_receipt, String reimb_author, String reimb_resolver,
			int reimb_statusid, int reimb_type_id, String reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_statusid = reimb_statusid;
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public String getReimb_receipt() {
		return reimb_receipt;
	}

	public void setReimb_receipt(String reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}

	public String getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(String reimb_author) {
		this.reimb_author = reimb_author;
	}

	public String getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(String reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_statusid() {
		return reimb_statusid;
	}

	public void setReimb_statusid(int reimb_statusid) {
		this.reimb_statusid = reimb_statusid;
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
	public String toString() {
		return "Ers_Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_statusid=" + reimb_statusid + ", reimb_type_id=" + reimb_type_id
				+ ", reimb_type=" + reimb_type + "]";
	}

	
}