/**
 * 
 */
package com.prs.model;
/**
 * @author Isura
 *
 */
public class ProfessionalBean {
	
private int auto_id;
private String user_id;
private String profession;
private String specify;
private String other_info;
private String tags;
private String headLine;
private String company;
private String phone;
private String address;
private String firstname;
private String lastname;


		public ProfessionalBean(int auto_id, String user_id, String profession, String specify, String other_info, String tags,
				String headLine, String company, String phone, String address, String firstname, String lastname) {
			super();
			this.auto_id = auto_id;
			this.user_id = user_id;
			this.profession = profession;
			this.specify = specify;
			this.other_info = other_info;
			this.tags = tags;
			this.headLine = headLine;
			this.company = company;
			this.phone = phone;
			this.address = address;
			this.firstname = firstname;
			this.lastname = lastname;
		}
		
		public ProfessionalBean() {
			// TODO Auto-generated constructor stub
		}

		public int getAuto_id() {
			return auto_id;
		}
		public void setAuto_id(int auto_id) {
			this.auto_id = auto_id;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getProfession() {
			return profession;
		}
		public void setProfession(String profession) {
			this.profession = profession;
		}
		public String getSpecify() {
			return specify;
		}
		public void setSpecify(String specify) {
			this.specify = specify;
		}
		public String getOther_info() {
			return other_info;
		}
		public void setOther_info(String other_info) {
			this.other_info = other_info;
		}
		public String getTags() {
			return tags;
		}
		public void setTags(String tags) {
			this.tags = tags;
		}
		public String getHeadLine() {
			return headLine;
		}
		public void setHeadLine(String headLine) {
			this.headLine = headLine;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		@Override
		public String toString() {
			return "ProfessionalBean [auto_id=" + auto_id + ", user_id=" + user_id + ", profession=" + profession
					+ ", specify=" + specify + ", other_info=" + other_info + ", tags=" + tags + ", headLine="
					+ headLine + ", company=" + company + ", phone=" + phone + ", address=" + address + ", firstname="
					+ firstname + ", lastname=" + lastname + "]";
		}
		
		
}
